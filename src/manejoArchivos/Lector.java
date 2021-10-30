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

public class Lector {



	public static ArrayList<Usuario> crearUsuario() {
		try {
			String sql = "SELECT * FROM USUARIOS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
			while (resultados.next()) {
				misUsuarios.add(toUsuario(resultados));
			}

			return misUsuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	private static Usuario toUsuario(ResultSet resultados) throws SQLException {
		//-------------------------nombre-------------------presupuesto---------------tiempo---------------Promocion---------------
		return new Usuario(resultados.getString(2),resultados.getInt(3), resultados.getDouble(4), TipoAtraccion.valueOf(resultados.getString(5)));
	}

public static Map<String, Producto> crearMapaAtraccion() {
		
		ArrayList<Producto> atracciones = crearAtraccion();
		Map<String, Producto> miMapaAtracciones = new HashMap<String, Producto>();
		
		for(Producto i: atracciones) {
			miMapaAtracciones.put(i.getNombre(),i);
		}
		return miMapaAtracciones;
	}
		

	public static ArrayList<Producto> crearAtraccion() {
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
		return new Atraccion(resultados.getString(2),resultados.getInt(3),TipoAtraccion.valueOf(resultados.getString(4)),resultados.getInt(5), resultados.getDouble(6));
	}

	public static ArrayList<Producto> crearPromos(HashMap<String, Producto> misAtracciones) {
		ArrayList<Producto> misPromos = new ArrayList<Producto>();
		
		try {
			String sql = "SELECT * FROM PROMOCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			while (resultados.next()){
				String[] cadaAtr = resultados.getString(2).split("&");
				ArrayList<Atraccion> atrEnLaPromo = new ArrayList<Atraccion>();

				for (String s : cadaAtr) {
					atrEnLaPromo.add((Atraccion) misAtracciones.get(s)); // mi array de atracciones que es un atributo de la clase
																// Promocion
				}

				if (resultados.getString(5).equals("ABSOLUTA")) {
					Promocion promo = new PromocionAbsoluta(atrEnLaPromo, resultados.getString(3), TipoAtraccion.valueOf(resultados.getString(4)),
							resultados.getDouble(6));
					misPromos.add(promo);
				} else if (resultados.getString(5).equals("PORCENTUAL")) {
					Promocion promo = new PromocionPorcentual(atrEnLaPromo, resultados.getString(3), TipoAtraccion.valueOf(resultados.getString(4)),
							resultados.getDouble(6));
					misPromos.add(promo);
				} else {
					Promocion promo = new PromocionAxB(atrEnLaPromo, resultados.getString(3), TipoAtraccion.valueOf(resultados.getString(4)));
					misPromos.add(promo);
				}

			}

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

		return misPromos;
	}

}
