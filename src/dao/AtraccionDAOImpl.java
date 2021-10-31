package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enums.TipoAtraccion;
import jdbc.ConnectionProvider;
import productos.Atraccion;
import productos.Producto;

public class AtraccionDAOImpl implements AtraccionDAO{

	@Override
	public ArrayList<Producto> findAll() {
		try {
			String sql = "SELECT * FROM ATRACCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Producto> misAtracciones = new ArrayList<Producto>();
			while (resultados.next()) {
				misAtracciones.add(toAtraccion(resultados));
			}

			return misAtracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private static Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		//-------------------------nombre----------------------costo---------------tipo--------------------------------------cupo-------------------tiempo
		return new Atraccion(resultados.getString(2),resultados.getInt(3), TipoAtraccion.valueOf(resultados.getString(4)),resultados.getInt(5), resultados.getDouble(6));
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producto atr) throws SQLException {
		String sql = "UPDATE Atraccion SET cupo=? WHERE nombre=?;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, ((Atraccion) atr).getCupo());
		statement.setString(2, atr.getNombre());
		statement.executeUpdate();
	
	}

	@Override
	public int delete(Producto t) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
