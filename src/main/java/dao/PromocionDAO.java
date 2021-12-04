package dao;

import java.util.ArrayList;
import java.util.HashMap;

import productos.Producto;

public interface PromocionDAO extends GenericDAO<Producto> {

	public ArrayList<Producto> findAll(HashMap<String, Producto> misAtracciones);
	
}
