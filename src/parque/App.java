package parque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import enums.TipoAtraccion;
import manejoArchivos.Lector;
import productos.Atraccion;
import productos.Producto;
import productos.Promocion;
import productos.PromocionPorcentual;

public class App {

	public static void main(String[] args) {

		ArrayList<Usuario> misUsuarios = Lector
				.crearUsuario();

		ArrayList<Producto> misAtracciones = Lector
				.crearAtraccion();
		Map<String, Producto> misAtracc = Lector
				.crearMapaAtraccion();
		ArrayList<Producto> misPromos = Lector.crearPromos((HashMap<String, Producto>) misAtracc);

		ParqueTierraMedia parqueAtracciones = new ParqueTierraMedia(misUsuarios, misPromos, misAtracciones);
		parqueAtracciones.ofrecerProducto(misUsuarios);

		
	}

}