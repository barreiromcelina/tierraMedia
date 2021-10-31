package dao;

import java.sql.SQLException;

import parque.Usuario;
import productos.Producto;

public interface ItinerarioDAO extends GenericDAO<Usuario> {

	int update(Usuario u) throws SQLException;

	

}
