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

public class Lector {

	//Hola este comentario es para probar el commit
	
	
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
						TipoAtraccion.valueOf(aux[3]), null);
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
	
	
public static Map<String, Atraccion> crearMapaAtraccion(String path) {
		
		Map<String, Atraccion> miMapaAtracciones = new HashMap<String, Atraccion>();
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			for (String linea = br.readLine(); linea != null; linea = br.readLine()) {
				String[] aux =  linea.split(",");
				//nombre costo tipo cupo y tiempoPromedio
				Atraccion unaAtraccion = new Atraccion(aux[0], Double.parseDouble(aux[1]), TipoAtraccion.valueOf(aux[2]), Integer.parseInt(aux[3]),
						Double.parseDouble(aux[4]));
				miMapaAtracciones.put(aux[0], unaAtraccion);
			}
		} catch ( IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr!=null)
					fr.close();
			} catch (Exception f) {
				f.printStackTrace();
			}
		}
		return miMapaAtracciones;
	}
	
	
	public static ArrayList<Atraccion> crearAtraccion(String path) {

		ArrayList<Atraccion> misAtracciones = new ArrayList<Atraccion>();
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

}
