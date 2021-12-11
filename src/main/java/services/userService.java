package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.TipoAtraccion;
import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class userService {

	public Usuario create(String nombre, String contraseña, Double presupuesto, Double tiempoDisponible,
			TipoAtraccion tipoPreferido) {
		Usuario user = new Usuario(-1, false, nombre, contraseña, presupuesto, tiempoDisponible, tipoPreferido);
		user.setPassword(contraseña);
		UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();
		userDAO.insert(user);

		return user;
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
