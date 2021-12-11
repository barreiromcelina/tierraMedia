package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Producto;
import model.Usuario;
import model.nullobjects.NullUser;
import persistence.ItinerarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	@Override
	public ArrayList<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM ITINERARIOS";
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

	// Recibe el Usuario desde el Escritor para guardar su Itinerario en la Base de
	// Datos
	@Override
	public int insert(Usuario u) {
		double gasto = u.PRESUPUESTO_INICIAL - u.getPresupuesto();
		double tiempo = u.TIEMPO_INICIAL - u.getTiempoDisponible();

		try {
			String sql = "INSERT INTO main.Itinerarios (ItinerarioPersona, Gasto, Duracion, Usuario) VALUES (?, ?, ?, ?);";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.stringItineario());
			statement.setDouble(2, u.getGastoAcumulado());
			statement.setDouble(3, u.getTiempoAcumulado());
			statement.setString(4, u.getNombre());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	// Recibiria el Usuario desde el Escritor para actualizar el Itinerario en la
	// Base de Datos
	@Override
	public int update(Usuario u) {
		try {
			String sql = "UPDATE Itinerarios SET ItinerarioPersona=?, Gasto=?, Duracion=? " + "WHERE Usuario=?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.stringItineario());
			statement.setDouble(2, (u.PRESUPUESTO_INICIAL - u.getPresupuesto()));
			statement.setDouble(3, (u.TIEMPO_INICIAL - u.getTiempoDisponible()));
			statement.setString(4, u.getNombre());

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public int delete(Usuario u) {
		try {
			String sql = "UPDATE ITINERARIOS SET BORRADO = 1 WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findItinerario(Usuario u) {
		try {
			String sql = "SELECT ItinerarioPersona FROM Itinerarios WHERE USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.getNombre());
			ResultSet resultados = statement.executeQuery();

			return resultados.getString(1);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}
	
	public Integer findUser(Usuario u) {
		try {
			String sql = "SELECT COUNT(USUARIO) FROM Itinerarios WHERE USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.getNombre());
			ResultSet resultados = statement.executeQuery();

			return resultados.getInt(1);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public Integer findCosto(Usuario u) {
		try {
			String sql = "SELECT Gasto FROM Itinerarios WHERE USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.getNombre());
			ResultSet resultados = statement.executeQuery();

			return resultados.getInt(1);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Integer findTiempo(Usuario u) {
		try {
			String sql = "SELECT Duracion FROM Itinerarios WHERE USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.getNombre());
			ResultSet resultados = statement.executeQuery();

			return resultados.getInt(1);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
