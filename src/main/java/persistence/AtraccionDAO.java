package persistence;

import java.util.ArrayList;

import model.Producto;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Producto> {

	public ArrayList<Producto> findAll();
	
}
