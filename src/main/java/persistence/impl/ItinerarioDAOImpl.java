package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atraccion;
import model.Producto;
import model.TipoAtraccion;
import model.Usuario;
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
			String sql = "INSERT INTO main.Itinerarios (ItinerarioPersona, Gasto, Duracion, Usuario, id_usuario) VALUES (?, ?, ?, ?, ?);";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.stringItineario());
			statement.setDouble(2, u.getGastoAcumulado());
			statement.setDouble(3, u.getTiempoAcumulado());
			statement.setString(4, u.getNombre());
			statement.setInt(5, u.getId());

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

	@Override
	public Integer insertItinerarioAtraccion(int userId, Integer atrId) {
		try {
			String sql = "INSERT INTO Itinerarios_Atraccion (id_itinerario, id_atraccion) "
					+ "VALUES ((SELECT id_itinerario FROM Itinerarios WHERE id_usuario = ?), ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);
			statement.setInt(2, atrId);
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public ArrayList<Producto> findItinerarioObjetcs(Integer userId) {
		try {
			String sql = "SELECT Atraccion.id_atraccion, Atraccion.nombre, Atraccion.costo, Atraccion.tipo, atraccion.cupo, Atraccion.tiempo "
					+ "FROM Itinerarios "
					+ "JOIN Itinerarios_Atraccion ON Itinerarios_Atraccion.id_itinerario = Itinerarios.id_itinerario "
					+ "JOIN Atraccion ON Atraccion.id_atraccion = Itinerarios_Atraccion.id_atraccion "
					+ "WHERE Itinerarios.id_usuario = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, userId);

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
		// ----id----nombre---costo---tipo---cupo----tiempo-------------------------
		return new Atraccion(resultados.getInt(1), resultados.getString(2), resultados.getInt(3),
				TipoAtraccion.valueOf(resultados.getString(4)), resultados.getInt(5), resultados.getDouble(6));
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
