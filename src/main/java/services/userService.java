package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.TipoAtraccion;
import model.Usuario;
import persistence.ItinerarioDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class userService {

	public Usuario create(String nombre, String contraseña, Double presupuesto, Double tiempoDisponible,
			TipoAtraccion tipoPreferido) {
		//Creo el objeto usuario con los datos ingresados
		Usuario userSinId = new Usuario(-1, false, nombre, contraseña, presupuesto, tiempoDisponible, tipoPreferido);
		userSinId.setPassword(contraseña);
		//lo guardo en la base de datos
		UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();
		userDAO.insert(userSinId);
		//lo busco denuevo para obtener tambien el id_usuario generado por la BD
		Integer userId = userDAO.findByNombre(userSinId.getNombre()).getId();
		//Construyo usuario con id
		Usuario userConId = new Usuario(userId,false, nombre, 
				contraseña, presupuesto, tiempoDisponible, tipoPreferido); 
		//creo un itinerario vacio con el cual empezar a comprar
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		itinerarioDAO.insert(userConId);
		
		return userConId;
	}

	public ArrayList<String> traerTiposPreferidos() {
		List<TipoAtraccion> tiposPreferidos = new ArrayList<TipoAtraccion>();
		tiposPreferidos = Arrays.asList(TipoAtraccion.values());
		ArrayList<String> tiposPreferidosString = new ArrayList<String>();

		for (int i = 0; i < tiposPreferidos.size(); i++) {
			tiposPreferidosString.add(tiposPreferidos.get(i).toString());
		}

		return tiposPreferidosString;
	}

	public Usuario obtenterUsuario(String user) {
		return DAOFactory.getUsuarioDAO().findByNombre(user);
	}

}
