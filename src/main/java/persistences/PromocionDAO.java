package persistences;

import java.util.ArrayList;
import java.util.HashMap;

import model.Producto;
import persistence.commons.GenericDAO;

public interface PromocionDAO extends GenericDAO<Producto> {

	public ArrayList<Producto> findAll(HashMap<String, Producto> misAtracciones);
	
}
