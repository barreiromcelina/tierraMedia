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
		// ----id----nombre---costo---tipo---cupo----tiempo-------------------------
		return new Atraccion(resultados.getInt(1) ,resultados.getString(2), resultados.getInt(3),
				TipoAtraccion.valueOf(resultados.getString(4)), resultados.getInt(5), resultados.getDouble(6));
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM ATRACCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Producto t) {
		try {
			String sql = "INSERT INTO ATRACCION (NOMBRE, COSTO, TIPO, CUPO, DURACION) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, t.getNombre());
			statement.setDouble(i++, t.getCosto());
			statement.setString(i++, t.getTipo().toString()); // checkear que esto funcione realmente
			statement.setInt(i++, ((Atraccion) t).getCupo());
			statement.setDouble(i++, t.getTiempoPromedio());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	//Actualiza el cupo de las Atracciones de la Base de Datos
	@Override
	public int update(Producto atr) {
		try {
			String sql = "UPDATE Atraccion SET NOMBRE = ?, COSTO = ?, TIPO = ?, CUPO = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, atr.getNombre());
			statement.setDouble(i++, atr.getCosto());
			statement.setString(i++, atr.getTipo().toString()); //checkear esto
			statement.setInt(i++, ((Atraccion) atr).getCupo());
			statement.setInt(i++, ((Atraccion) atr).getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Producto t) {
		try {
			String sql = "DELETE FROM ATRACCION WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, ((Atraccion) t).getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Producto find(Integer id) {
		try {
			String sql = "SELECT * FROM ATRACCION WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			Atraccion unaAtraccion = null;
			if (resultados.next()) {
				unaAtraccion = toAtraccion(resultados);
			}

			return unaAtraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
