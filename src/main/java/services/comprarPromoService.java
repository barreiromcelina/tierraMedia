package services;

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

	public Map<String, String> comprar(int userId, Integer promoId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = usuarioDAO.find(userId);
		if (itinerarioDAO.findUser(user) <= 0) {
			itinerarioDAO.insert(user);
			ArrayList<Producto> miItinerario = user.getItinerario();
		}

		Promocion promocion = (Promocion) promocionDAO.find(promoId);

		ArrayList<Producto> miItinerario = itinerarioDAO.findItinerarioObjetcs(userId);
		user.setGastoAcumulado(itinerarioDAO.findCosto(user));
		user.setTiempoAcumulado(itinerarioDAO.findTiempo(user));

		// Aqui deberia ir la logica que verifica si
		// Cada atraccion contenida en la promo, tiene cupo
		// el usuario puede pagar
		// el usuario dispone de tiempo

		if (errors.isEmpty()) {
			user.comprar(promocion);
			miItinerario.add(promocion);

			user.setItinerario(miItinerario);

			promocionDAO.update(promocion);
			usuarioDAO.update(user);

			itinerarioDAO.update(user);
			itinerarioDAO.insertItinerarioAtraccion(userId, promoId);
		}

		return errors;
	}

}
