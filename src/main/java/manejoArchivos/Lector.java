package manejoArchivos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.MissingDataException;
import dao.PromocionDAO;
import dao.UsuarioDAO;
import parque.Usuario;
import productos.Producto;

public class Lector {

	//Crea el ArrayList de Usuario Desde la Base de Datos
	public static ArrayList<Usuario> crearUsuario() {
		try {
			ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
			UsuarioDAO UsuarioDAO = DAOFactory.getUsuarioDAO();
			misUsuarios = UsuarioDAO.findAll();

			return misUsuarios;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public static Map<String, Producto> crearMapaAtraccion(ArrayList<Producto> misAtracciones) {

		Map<String, Producto> miMapaAtracciones = new HashMap<String, Producto>();

		for (Producto i : misAtracciones) {
			miMapaAtracciones.put(i.getNombre(), i);
		}
		return miMapaAtracciones;
	}

	//Crea la Lista de Atracciones desde la Base de datos
	public static ArrayList<Producto> crearAtraccion() {
		try {
			ArrayList<Producto> misAtracciones = new ArrayList<Producto>();
			AtraccionDAO AtraccionDAO = DAOFactory.getAtraccionDAO();
			misAtracciones = AtraccionDAO.findAll();

			return misAtracciones;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	//Crea la lista de Promociones desde la Base de Datos
	public static ArrayList<Producto> crearPromos(HashMap<String, Producto> misAtracciones) {
		ArrayList<Producto> misPromos = new ArrayList<Producto>();

		try {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			misPromos = promocionDAO.findAll(misAtracciones);

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

		return misPromos;
	}

}
