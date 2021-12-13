package parque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import manejoArchivos.Lector;
import model.Producto;
import model.Usuario;

public class App {
 
	
	public static void main (String args[]) {
		 
				
		ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
		misUsuarios = Lector.crearUsuario();
		
		ArrayList<Producto> misAtracciones = new ArrayList<Producto>();
		misAtracciones = Lector.crearAtraccion();
		
		Map<String, Producto> misAtracc = Lector.crearMapaAtraccion(misAtracciones);
		
		
		ArrayList<Producto> misPromos = new ArrayList<Producto>();
		misPromos = Lector.crearPromos((HashMap<String, Producto>) misAtracc);
		
		ParqueTierraMedia parqueAtracciones = new ParqueTierraMedia(misUsuarios, misPromos, misAtracciones);
		parqueAtracciones.ofrecerProducto(misUsuarios);
		
		
		
		
		
	}
}