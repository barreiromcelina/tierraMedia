package services;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import model.Atraccion;
import model.OrdenarSegunPreferencia;
import model.Producto;
import model.Usuario;
import persistence.commons.DAOFactory;

public class atraccionService {

	public List<Producto> obtenerAllAtracciones() throws SQLException {
		return DAOFactory.getAtraccionDAO().findAll();
	}

	public List<Producto> obtenerAllAtraccionesOrdenadas(Usuario usuario) {
		List<Producto> atraccionesOrdenadas= DAOFactory.getAtraccionDAO().findAll();
		Collections.sort(atraccionesOrdenadas, new OrdenarSegunPreferencia(usuario.getTipoAtraccionPreferida()));
		return atraccionesOrdenadas;
	}

	public void borrar(Integer id) {
		Atraccion atr = (Atraccion) DAOFactory.getAtraccionDAO().find(id);
		DAOFactory.getAtraccionDAO().delete(atr);
		
	}

}
