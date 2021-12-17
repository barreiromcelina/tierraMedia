package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Atraccion;
import model.TipoAtraccion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;
import persistence.impl.UsuarioDAOImpl;

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
	
	public ArrayList<Usuario> traerTodos() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = DAOFactory.getUsuarioDAO().findAll();
		
		return usuarios;
	}
	

	public Usuario obtenterUsuario(String user) {
		return DAOFactory.getUsuarioDAO().findByNombre(user);
	}
	
	public Usuario obtenerUsuarioPorId(Integer userId) {
		return DAOFactory.getUsuarioDAO().find(userId);
	}
	
	public Usuario edit(Integer userId, Boolean admin, String nombre, String contraseña, Double presupuesto, 
			Double tiempoDisponible, TipoAtraccion tipoPreferido) {
		UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();

		Usuario usuarioEditado = new Usuario(userId, admin, nombre, contraseña, presupuesto, tiempoDisponible, tipoPreferido);
		usuarioEditado.setPassword(contraseña);
		
		
		userDAO.edit(usuarioEditado);
		return usuarioEditado;
	}

	public void borrar(Integer userId) {
		Usuario usuario = DAOFactory.getUsuarioDAO().find(userId);
		DAOFactory.getUsuarioDAO().delete(usuario);
		
	}

}
