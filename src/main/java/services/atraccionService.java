package services;

import java.sql.SQLException;
import java.util.List;

import model.Producto;
import persistence.commons.DAOFactory;

public class atraccionService {

	public List<Producto> obtenerAllAtracciones() throws SQLException {
		List<Producto> misAtracciones = DAOFactory.getAtraccionDAO().findAll();
		return misAtracciones;
	}

}
