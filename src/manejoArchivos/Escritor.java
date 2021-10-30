package manejoArchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import dao.MissingDataException;

import enums.TipoAtraccion;
import jdbc.ConnectionProvider;
import parque.Usuario;
import productos.Atraccion;
import productos.Producto;
import productos.Promocion;
import productos.PromocionAbsoluta;
import productos.PromocionAxB;
import productos.PromocionPorcentual;

import parque.Usuario;
import productos.Producto;

public class Escritor {
	
Usuario usuario;
	
	
	
	public Escritor(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public static int guardarItinerario(Usuario usuario) {
		try {
			String sql = "UPDATE ITINERARIOS SET ITINERARIOPERSONA  = ? WHERE USUARIO = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuario.stringItineario());
			statement.setString(2, usuario.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public static int guardarGasto(Usuario usuario) {
		
		double gasto = usuario.PRESUPUESTO_INICIAL -usuario.getPresupuesto();
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
		
		double tiempo = usuario.TIEMPO_INICIAL- usuario.getTiempoDisponible();
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
	

	
	

