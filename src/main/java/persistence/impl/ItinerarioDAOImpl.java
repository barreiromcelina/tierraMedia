package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.Usuario;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import persistences.ItinerarioDAO;

public class ItinerarioDAOImpl implements ItinerarioDAO {

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

	//Recibe el Usuario desde el Escritor para guardar su Itinerario en la Base de Datos
	@Override
	public int insert(Usuario u) {
		double gasto = u.PRESUPUESTO_INICIAL -u.getPresupuesto();
		double tiempo = u.TIEMPO_INICIAL- u.getTiempoDisponible();
		
		try {
			String sql = "INSERT INTO main.Itinerarios (ItinerarioPersona, Gasto, Duracion, Usuario) VALUES (?, ?, ?, ?);";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, u.stringItineario());
			statement.setDouble(2, gasto);
			statement.setDouble(3, tiempo);
			statement.setString(4, u.getNombre());

			int rows = statement.executeUpdate();
			
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	//Recibiria el Usuario desde el Escritor para actualizar el Itinerario en la Base de Datos
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
		// TODO Auto-generated method stub
		return 0;
	}

}
