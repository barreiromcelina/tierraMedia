package manejoArchivos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.Atraccion;
import model.Producto;
import model.Promocion;
import model.Usuario;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;
import persistences.AtraccionDAO;
import persistences.ItinerarioDAO;
import persistences.UsuarioDAO;

public class Escritor {

	Usuario usuario;

	public Escritor(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	//Recibe el Usuario al cual ya se le genero el Itinerario usando la App.java y guarda el Itinerario en la Base de Datos
	public static int guardarItinerario(Usuario usuario) {
		try {
			ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
			int rows = itinerarioDAO.insert(usuario);

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	//Recibe el Usuario con el Presupuesto y tiempoDisponible actualizados y listos para guardarse en Base de Datos
	public static int actualizarUsuario(Usuario usuario) {

		try {
			UsuarioDAO UsuarioDAO = DAOFactory.getUsuarioDAO();
			int rows = UsuarioDAO.update(usuario);

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	//Recibe el Itinerario generado para el Usuario y actualiza el cupo de cada atraccion tanto sueltas como dentro de promociones
	public static int actualizarCupoDeAtraccion(ArrayList<Producto> miItinerario) {

		try {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			int rows = 0;
			//por cada elemento de miItinerario
			for (int i = 0; i<miItinerario.size(); i++) {
				//Miro si es promocion
				if(miItinerario.get(i).esPromo()) {
					Promocion promocion = (Promocion) miItinerario.get(i);
					//Entonces por cada elemento de mi promocion
					for (int j = 0; j<promocion.getPromos().size(); j++) {
						//Voy actualizando una a una cada atraccion de la promocion
						Atraccion unaAtraccion = promocion.getPromos().get(j);
						rows = rows + atraccionDAO.update(unaAtraccion);
					}
				} else { //Si no es promocion, es atraccion suelta y la actualizo
					Atraccion unaAtraccion = (Atraccion) miItinerario.get(i);
					rows = rows + atraccionDAO.update(unaAtraccion);
				}
					
			}
			
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	//Metodos en desuso pero que sirvieron para desarrollar los utilizados arriba
	public static int guardarGasto(Usuario usuario) {

		double gasto = usuario.PRESUPUESTO_INICIAL - usuario.getPresupuesto();
		try {
			String sql = "UPDATE ITINERARIOS SET GASTO  = ? WHERE USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, gasto);
			statement.setString(2, usuario.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public static int guardarDuracion(Usuario usuario) {

		double tiempo = usuario.TIEMPO_INICIAL - usuario.getTiempoDisponible();
		try {
			String sql = "UPDATE ITINERARIOS SET DURACION  = ? WHERE USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, tiempo);
			statement.setString(2, usuario.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

}
