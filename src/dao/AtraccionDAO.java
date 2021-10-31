package dao;

import java.util.ArrayList;

import productos.Producto;

public interface AtraccionDAO extends GenericDAO<Producto> {

	public ArrayList<Producto> findAll();
	
}
