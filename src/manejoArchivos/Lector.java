package manejoArchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import enums.TipoAtraccion;
import parque.Usuario;
import productos.Atraccion;
import productos.Producto;
import productos.Promocion;
import productos.PromocionAbsoluta;
import productos.PromocionAxB;
import productos.PromocionPorcentual;

public class Lector {

	// Hola este comentario es para probar el commit

	public static ArrayList<Usuario> crearUsuario(String path) {

		ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			for (String linea = br.readLine(); linea != null; linea = br.readLine()) {

				String[] aux = linea.split(",");
				Usuario unUsuario = new Usuario(aux[0], Double.parseDouble(aux[1]), Double.parseDouble(aux[2]),
						TipoAtraccion.valueOf(aux[3]));
				misUsuarios.add(unUsuario);

			}
		}

		catch (IOException e) {
			e.printStackTrace();
			;
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception f) {
				f.printStackTrace();

			}
		}

		return misUsuarios;

	}

	public static Map<String, Producto> crearMapaAtraccion(String path) {

		Map<String, Producto> miMapaAtracciones = new HashMap<String, Producto>();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
				String[] aux = linea.split(",");
				// nombre costo tipo cupo y tiempoPromedio
				Atraccion unaAtraccion = new Atraccion(aux[0], Double.parseDouble(aux[1]),
						TipoAtraccion.valueOf(aux[2]), Integer.parseInt(aux[3]), Double.parseDouble(aux[4]));
				miMapaAtracciones.put(aux[0], unaAtraccion);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception f) {
				f.printStackTrace();
			}
		}
		return miMapaAtracciones;
	}

	public static ArrayList<Producto> crearAtraccion(String path) {

		ArrayList<Producto> misAtracciones = new ArrayList<Producto>();
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			for (String linea = br.readLine(); linea != null; linea = br.readLine()) {

				String[] aux = linea.split(",");
				Atraccion unaAtraccion = new Atraccion(aux[0], Double.parseDouble(aux[1]),
						TipoAtraccion.valueOf(aux[2]), Integer.parseInt(aux[3]), Double.parseDouble(aux[4]));
				misAtracciones.add(unaAtraccion);

			}
		}

		catch (IOException e) {
			e.printStackTrace();
			;
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception f) {
				f.printStackTrace();

			}
		}

		return misAtracciones;

	}

	public static ArrayList<Producto> crearPromos(String path, HashMap<String, Producto> misAtracciones) {
		ArrayList<Producto> misPromos = new ArrayList<Producto>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
				String[] aux = linea.split(",");
				String[] cadaAtr = aux[0].split("&");
				ArrayList<Atraccion> atrEnLaPromo = new ArrayList<Atraccion>();

				for (String s : cadaAtr) {
					atrEnLaPromo.add((Atraccion) misAtracciones.get(s)); // mi array de atracciones que es un atributo de la clase
																// Promocion
				}

				if (aux[3].equals("ABSOLUTA")) {
					Promocion promo = new PromocionAbsoluta(atrEnLaPromo, aux[1], TipoAtraccion.valueOf(aux[2]),
							Double.parseDouble(aux[4]));
					misPromos.add(promo);
				} else if (aux[3].equals("PORCENTUAL")) {
					Promocion promo = new PromocionPorcentual(atrEnLaPromo, aux[1], TipoAtraccion.valueOf(aux[2]),
							Double.parseDouble(aux[4]));
					misPromos.add(promo);
				} else {
					Promocion promo = new PromocionAxB(atrEnLaPromo, aux[1], TipoAtraccion.valueOf(aux[2]));
					misPromos.add(promo);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception f) {
				f.printStackTrace();
			}
		}

		return misPromos;
	}

}
