package parque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import enums.TipoAtraccion;
import productos.Atraccion;
import productos.Producto;
import productos.PromocionPorcentual;
import manejoArchivos.Escritor;
import manejoArchivos.Lector;

public class ParqueTierraMedia {

	private ArrayList<Usuario> misUsuarios;
	private static ArrayList<Producto> misProductos = new ArrayList<Producto>();

	public ParqueTierraMedia(ArrayList<Usuario> misUsuarios, ArrayList<Producto> promos,
			ArrayList<Producto> atracciones) {
		this.misUsuarios = misUsuarios;
		this.misProductos = misProductos(promos, atracciones);

	}

	public ArrayList<Producto> misProductos(ArrayList<Producto> promos, ArrayList<Producto> atracciones) {

		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.addAll(promos);
		listaProductos.addAll(atracciones);

		return listaProductos;
	}

	public static void misProductosOrdenadosPorPreferencia(Usuario usuario) {
		Collections.sort(misProductos, new OrdenarSegunPreferencia(usuario.getTipoAtraccionPreferida()));
	}

	public static void oferecerProducto(ArrayList<Usuario> misUsuarios) {

		ArrayList<Producto> miItinerario = new ArrayList<Producto>();

		Boolean yaEsta = false;

		for (Usuario usuario : misUsuarios) {
			misProductosOrdenadosPorPreferencia(usuario);
			try {
				for (Producto producto : misProductos) {

					if (miItinerario.contains(producto)) {
						yaEsta = true;

					}

					if (usuario.getPresupuesto() < producto.getCosto()
							|| usuario.getTiempoDisponible() < producto.getTiempoPromedio() || yaEsta
							|| producto.getCupo() == 0) {
						continue;

					}
					System.out.println("Usted quiere comprar este producto: y/n" + "\n" + producto);

					Scanner sc = new Scanner(System.in);
					String respuesta = sc.next();

					try {
						if (respuesta.equalsIgnoreCase("y")) {
							usuario.comprar(producto);
							miItinerario.add(producto);
						} else if (!respuesta.equalsIgnoreCase("n"))
							throw new IllegalArgumentException("Por favor ingrese n o y solamente ");
					}

					catch (IllegalArgumentException error) {
						System.err.println(error.getMessage());
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			usuario.setItinerario(miItinerario);
			Escritor.imprimirArchivo(usuario);
		}
		
		//System.out.println(usuario.getItinerario());
		
	}

	public static void main(String[] args) {
		Atraccion atraccion1 = new Atraccion("Moria", 10, TipoAtraccion.AVENTURA, 6, 2);
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
		misProductos.add(atraccion4);
		misProductos.add(atraccion5);
		misProductos.add(atraccion6);
		misProductos.add(atraccion7);
		misProductos.add(atraccion8);
		misProductos.add(atraccion9);

		Collections.sort(misProductos, new OrdenarSegunPreferencia(TipoAtraccion.AVENTURA));

		System.out.println(misProductos);
		System.out.println("--------------------");
		Collections.sort(misProductos, new OrdenarSegunPreferencia(TipoAtraccion.PAISAJE));

		System.out.println(misProductos);
		System.out.println("--------------------");
		Collections.sort(misProductos, new OrdenarSegunPreferencia(TipoAtraccion.DEGUSTACION));

		System.out.println(misProductos);

		ArrayList<Usuario> misUsuarios = Lector
				.crearUsuario("C:\\Users\\celib\\eclipse-workspace\\TierraMedia\\archivos\\usuarios.csv");
		
		ParqueTierraMedia.oferecerProducto(misUsuarios);
		
	

	}

}
