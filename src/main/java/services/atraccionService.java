package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.Atraccion;

import model.OrdenarSegunPreferencia;
import model.Producto;
import model.TipoAtraccion;
import model.Usuario;
import persistence.AtraccionDAO;

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

	public Atraccion find(Integer atrId) {
		return (Atraccion) DAOFactory.getAtraccionDAO().find(atrId) ;
	}

	public ArrayList<String> traerTiposAtraccion() {
		List<TipoAtraccion> tiposAtraccion = new ArrayList<TipoAtraccion>();
		tiposAtraccion = Arrays.asList(TipoAtraccion.values());
		ArrayList<String> tiposAtraccionString = new ArrayList<String>();

		for (int i = 0; i < tiposAtraccion.size(); i++) {
			tiposAtraccionString.add(tiposAtraccion.get(i).toString());
		}

		return tiposAtraccionString;
		
	}

	

	public Atraccion update(Integer id, String nombre, Double costo, Integer cupo, Double tiempo) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = (Atraccion) atraccionDAO.find(id);

		atraccion.setNombre(nombre);
		atraccion.setCosto(costo);
		atraccion.setTiempoPromedio(tiempo);
		atraccion.setCupo(cupo);
		
		atraccionDAO.update(atraccion);
		return atraccion ;
	}

}
