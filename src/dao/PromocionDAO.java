package dao;

import java.util.ArrayList;

import productos.Producto;

public interface PromocionDAO extends GenericDAO<Producto> {

	public ArrayList<Producto> findAll();
	
}
