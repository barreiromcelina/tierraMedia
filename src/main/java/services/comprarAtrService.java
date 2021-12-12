package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Producto;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class comprarAtrService {

	AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
	UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
	

	public Map<String, String> comprar(int userId, Integer atrId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario user = usuarioDAO.find(userId);
		if(itinerarioDAO.findUser(user)<=0) {
			itinerarioDAO.insert(user);
		}
		Atraccion atraccion = (Atraccion) atraccionDAO.find(atrId);
		
		ArrayList<Producto> miItinerario = user.getItinerario();

		if (!atraccion.hayCupo()) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.puedePagar(atraccion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.tieneTiempo(atraccion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.comprar(atraccion);
			
			miItinerario.add(atraccion);
			user.setItinerario(miItinerario);
			

			atraccionDAO.update(atraccion);
			usuarioDAO.update(user);

			if(itinerarioDAO.findUser(user)>0) {
				itinerarioDAO.update(user);
			}else {
				itinerarioDAO.insert(user);
				itinerarioDAO.update(user);

			}
		}

		
		return errors;
	}

}
