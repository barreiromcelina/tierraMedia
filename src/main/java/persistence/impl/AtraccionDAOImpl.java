package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atraccion;
import model.Producto;
import model.TipoAtraccion;
import persistence.AtraccionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class AtraccionDAOImpl implements AtraccionDAO {

	//Trae todas las atracciones de la Base de Datos
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

	//Convierte el ResultSet a Atracciones
	private static Atraccion toAtraccion(ResultSet resultados) throws SQLException {
		// -------------------------nombre----------------------costo---------------tipo--------------------------------------cupo-------------------tiempo
		return new Atraccion(resultados.getString(2), resultados.getInt(3),
				TipoAtraccion.valueOf(resultados.getString(4)), resultados.getInt(5), resultados.getDouble(6));
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Producto t) {
		// TODO Auto-generated method stub
		return 0;

	}

	//Actualiza el cupo de las Atracciones de la Base de Datos
	@Override
	public int update(Producto atr) {
		try {
			String sql = "UPDATE Atraccion SET cupo=? WHERE nombre=?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, ((Atraccion) atr).getCupo());
			statement.setString(2, atr.getNombre());
			int rows = statement.executeUpdate();
			
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public int delete(Producto t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Producto find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
