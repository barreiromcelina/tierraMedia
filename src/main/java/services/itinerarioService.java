package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Producto;
import model.Usuario;
import persistence.ItinerarioDAO;
import persistence.commons.DAOFactory;

public class itinerarioService {

	ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
	
	public String obtenerItinerario(Usuario user) {
		 
		String itinerarioString = "";
		itinerarioString = DAOFactory.getItinerarioDAO().findItinerario(user);
		
		
		return itinerarioString;
	}

	public ArrayList<Producto> obtenerItinerarioObjects(Integer userId) {
		
		
		promoService pService = new promoService();
		HashMap<String, Producto> mapaAtracciones = (HashMap<String, Producto>) pService.crearMapaAtraccion();
		
		ArrayList<Producto> itinerarioProductos = new ArrayList<Producto>(); //creo el arraylist vacio
		itinerarioProductos.addAll(itinerarioDAO.findItinerarioAtracciones(userId)); //traigo las atracciones asociadas a esa id_usuario
		itinerarioProductos.addAll(itinerarioDAO.findItinerarioPromos(mapaAtracciones, userId)); //traigo las promociones asociadas a esa id_usuario
		
		
		
		return itinerarioProductos;
	}
	
	public Integer obtenerCostoTotal(Usuario user) {
		
		return DAOFactory.getItinerarioDAO().findCosto(user);
	}

	public Integer obtenerTiempoTotal(Usuario user) {
		
		return DAOFactory.getItinerarioDAO().findTiempo(user);
	}
	
	public ArrayList<Producto> settearItinerario(Usuario user){
		ArrayList<Producto> miItinerario = obtenerItinerarioObjects(user.getId());
		user.setItinerario(miItinerario);
		
		return miItinerario;
	}
	
	

}
