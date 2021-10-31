package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionProvider;
import parque.Usuario;
import productos.Producto;

public class ItinerarioDAOImpl implements ItinerarioDAO{

	@Override
	public ArrayList<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void insert(Usuario u) throws SQLException{
		String sql = "INSERT INTO  Itinerarios(Usuario) "
				+ "VALUE(?)";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, u.getNombre());
		
		statement.executeUpdate();
		
	}

	public  int update(Usuario u) throws SQLException {
		String sql = "UPADATE Itinerarios SET ItinerarioPersona=?, Gasto=?, Duracion=? "
				+ "WHERE Usuario=?;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, u.stringItineario());
		statement.setDouble(2, (u.PRESUPUESTO_INICIAL-u.getPresupuesto()));
		statement.setDouble(3, (u.TIEMPO_INICIAL-u.getTiempoDisponible()));
		statement.setString(4, u.getNombre());
		
		return statement.executeUpdate();
		
	}

	@Override
	public int delete(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
