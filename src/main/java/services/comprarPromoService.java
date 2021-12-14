package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Producto;
import model.Promocion;
import model.Usuario;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class comprarPromoService {

	PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
	itinerarioService itinerarioService = new itinerarioService();
	promoService pService = new promoService();

	public Map<String, String> comprar(int userId, Integer promoId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = usuarioDAO.find(userId);
		if (itinerarioDAO.findUser(user) <= 0) {
			itinerarioDAO.insert(user);
			ArrayList<Producto> miItinerario = user.getItinerario();
		}

		
		HashMap<String, Producto> mapaAtracciones = (HashMap<String, Producto>) pService.crearMapaAtraccion();
		Promocion promocion = (Promocion) promocionDAO.find(mapaAtracciones, promoId);

		ArrayList<Producto> miItinerario = itinerarioService.obtenerItinerarioObjects(userId);
		user.setGastoAcumulado(itinerarioDAO.findCosto(user));
		user.setTiempoAcumulado(itinerarioDAO.findTiempo(user));

		
		if (!promocion.hayCupo()) { 
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.puedePagar(promocion)) { 
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.tieneTiempo(promocion)) { 
			errors.put("user", "No tienes tiempo suficiente");
		}
		

		if (errors.isEmpty()) {
			user.comprar(promocion);
			miItinerario.add(promocion);

			user.setItinerario(miItinerario);

			promocionDAO.update(promocion);
			usuarioDAO.update(user);

			itinerarioDAO.update(user);
			itinerarioDAO.insertItinerarioPromocion(userId, promoId);
		}

		return errors;
	}

}
