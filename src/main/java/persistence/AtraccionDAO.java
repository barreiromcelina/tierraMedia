package persistence;

import java.util.ArrayList;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {

	public ArrayList<Atraccion> findAll();
	
}
