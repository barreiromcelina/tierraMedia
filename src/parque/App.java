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
			.crearUsuario("C:\\Users\\celib\\eclipse-workspace\\TierraMedia\\archivos\\usuarios.csv");
	
	ArrayList<Producto> misAtracciones= Lector.crearAtraccion("C:\\Users\\celib\\eclipse-workspace\\TierraMedia\\archivos\\atracciones.csv");
    Map<String, Producto> misAtracc= Lector.crearMapaAtraccion("C:\\Users\\celib\\eclipse-workspace\\TierraMedia\\archivos\\atracciones.csv");
	ArrayList<Producto>	misPromos= Lector.crearPromos("C:\\Users\\celib\\eclipse-workspace\\TierraMedia\\archivos\\promos.csv", (HashMap<String, Producto>) misAtracc);
	
	
	/*Atraccion atraccion1 = new Atraccion("Moria", 10, TipoAtraccion.AVENTURA, 6, 2);
	Atraccion atraccion2 = new Atraccion("Minas Tirith", 5, TipoAtraccion.PAISAJE, 25, 2.5);
	Atraccion atraccion3 = new Atraccion("La Comarca", 3, TipoAtraccion.DEGUSTACION, 150, 6.5);
	Atraccion atraccion4 = new Atraccion("Mordor", 25, TipoAtraccion.AVENTURA, 4, 3);
	Atraccion atraccion5 = new Atraccion("Monta", 15, TipoAtraccion.AVENTURA, 5, 3);
	Atraccion atraccion6 = new Atraccion("Abismos de Helm", 5, TipoAtraccion.PAISAJE, 15, 2);
	Atraccion atraccion7 = new Atraccion("Lothlórien", 35, TipoAtraccion.DEGUSTACION, 30, 1);
	Atraccion atraccion8 = new Atraccion("Erebor", 12, TipoAtraccion.PAISAJE, 32, 3);
	Atraccion atraccion9 = new Atraccion("Bosque Negro", 3, TipoAtraccion.AVENTURA, 12, 4);

	ArrayList<Atraccion> arrayAventura = new ArrayList<Atraccion>();
	ArrayList<Atraccion> arrayPaisaje = new ArrayList<Atraccion>();
	ArrayList<Atraccion> arrayDegustacion = new ArrayList<Atraccion>();

	// armo los paquetes de promocion
	// bosque negro y mordor
	arrayAventura.add(atraccion9);
	arrayAventura.add(atraccion4);

	// minas tirith abismo de hel y herebor
	arrayPaisaje.add(atraccion2);
	arrayPaisaje.add(atraccion6);
	arrayPaisaje.add(atraccion8);

	// Lothlorien y La COmarca
	arrayDegustacion.add(atraccion3);
	arrayDegustacion.add(atraccion7);

	Producto promoAventura = new PromocionPorcentual(arrayAventura, "Pack Aventura", TipoAtraccion.AVENTURA, 0.2);
	Producto promoPaisaje = new PromocionPorcentual(arrayPaisaje, "Pack Paisaje", TipoAtraccion.PAISAJE, 0.1);
	Producto promoDegustacion = new PromocionPorcentual(arrayDegustacion, "Pack Degustacion",
			TipoAtraccion.DEGUSTACION, 0.4);

	ArrayList<Producto> misProductos = new ArrayList<Producto>();

	// armo el array de productos a ordenar
	misProductos.add(promoAventura);
	misProductos.add(promoPaisaje);
	misProductos.add(promoDegustacion);
	misProductos.add(atraccion1);
	misProductos.add(atraccion2);
	misProductos.add(atraccion3);
	misProductos.add(atraccion4);y
	misProductos.add(atraccion5);
	misProductos.add(atraccion6);
	misProductos.add(atraccion7);
	misProductos.add(atraccion8);
	misProductos.add(atraccion9);*/
	ParqueTierraMedia parqueAtracciones = new ParqueTierraMedia(misUsuarios, misPromos, misAtracciones);
	parqueAtracciones.oferecerProducto(misUsuarios);
	
	
	}

}
