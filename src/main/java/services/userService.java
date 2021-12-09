package services;

import model.TipoAtraccion;
import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class userService {

	public Usuario create(String nombre, String contraseña, Double presupuesto, Double tiempoDisponible, TipoAtraccion tipoPreferido) {
		Usuario user = new Usuario(-1, false, nombre, contraseña, presupuesto, tiempoDisponible, tipoPreferido);
		user.setPassword(contraseña);
		UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();
		userDAO.insert(user);
		
		return user;
	}
	
	public Usuario obtenterUsuario(String user) {
		return DAOFactory.getUsuarioDAO().findByNombre(user);
	}

}
