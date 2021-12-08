package services;

import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class userService {

	public Usuario create(String nombre, String contraseña) {
		Usuario user = new Usuario(-1, false, nombre, contraseña, 0, 0, null);
		
		UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();
		userDAO.insert(user);
		
		return user;
	}

}
