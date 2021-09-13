package parque;

import java.util.ArrayList;
import java.util.Scanner;

import manejoArchivos.Cadena;
import enums.TipoAtraccion;
import productos.*;

public interface SistemaDeVenta {

	public static void venderProductosA(Usuario usuario, ArrayList<Producto> productosAVender) {

		System.out.println(usuario.getNombre() + " " + usuario.getPresupuesto() + "p " + usuario.getHoras() + "h");
		cartelito(productosAVender);

//		for (Producto productoActual : productosAVender)
//				System.out.println	(cadenaPerfecta(productoActual, productosAVender) + " ");
//		
		
		for (Producto productoActual : productosAVender) {
			if (comprobrarCapacidadDeCompraDe(usuario, productoActual)) {
				System.out.print(cadenaPerfecta(productoActual, productosAVender) + " ");
				ofrecer(productoActual, usuario);
			}
		//System.out.println(cadenaPerfecta(productoActual, productosAVender) + " ");
		}
	}

	private static boolean comprobrarCapacidadDeCompraDe(Usuario usuario, Producto aComprar) {
		boolean meAlcanza = usuario.getPresupuesto() >= aComprar.getPrecio();
		boolean tengoTiempo = usuario.getHoras() >= aComprar.getHoras();
		boolean hayEspacio = aComprar.getCupos() > 0;
		boolean loCompreYa = false;

		// #atraccion
		if (Atraccion.class.isInstance(aComprar))
			loCompreYa = usuario.getItinerario().contains(aComprar);
		// #promocion
		if (Promocion.class.isInstance(aComprar))
			for (Atraccion atraccion : ((Promocion) aComprar).getContenido())
				loCompreYa |= usuario.getItinerario().contains(atraccion);

		boolean siPuede = meAlcanza && tengoTiempo && hayEspacio && !loCompreYa;
		return siPuede;
	}

	private static void comprar(Producto producto, Usuario usuario) {
		cobrarA(usuario, producto);
		adicionarProductoAlItinerarioDe(usuario, producto);
	}

	private static void cobrarA(Usuario usuario, Producto producto) {
		// #persona
		usuario.setPresupuesto(usuario.getPresupuesto() - producto.getPrecio());
		usuario.setHoras(usuario.getHoras() - producto.getHoras());

		// #producto
		producto.setCupos(producto.getCupos() - 1);
		if (Promocion.class.isInstance(producto))
			for (Atraccion atraccion : ((Promocion) producto).getContenido())
				atraccion.setCupos(atraccion.getCupos() - 1);
	}

	private static void adicionarProductoAlItinerarioDe(Usuario usuario, Producto producto) {
		// #atraccion
		if (Atraccion.class.isInstance(producto))
			usuario.getItinerario().add(producto);

		// #promocion
		if (Promocion.class.isInstance(producto))
			for (Atraccion atraccion : ((Promocion) producto).getContenido())
				usuario.getItinerario().add(atraccion);
	}

	private static void ofrecer(Producto producto, Usuario usuario) {
		Scanner sc = new Scanner(System.in);
		String respuesta = sc.next();
		try {
			if(respuesta.equalsIgnoreCase("Y")) {
				comprar(producto,usuario);
			}
			else if(!respuesta.equalsIgnoreCase("N"))
				throw new IllegalArgumentException("Por favor ingrese N o  Y solamente ");
		}
		catch (IllegalArgumentException error) {
			System.err.println(error.getMessage());
			ofrecer(producto,usuario);
		}
		
//		switch (respuesta) {
//		case "y":
//		case "Y":
//		case "yes":
//		case "Yes":
//			comprar(producto, usuario);
//			break;
//		case "n":
//		case "N":
//		case "no":
//		case "No":
//			break;
//		default:
//			System.err.print(
//					" • " + new IllegalArgumentException("Caracter no permitido: " + respuesta).getMessage() + ".");
//			System.out.print(" por favor reinsertar: ");
//			ofrecer(producto, usuario);
//		}
	}

	//#print bellos
	private static String cadenaPerfecta(Producto producto, ArrayList<? extends Producto> segun) {

		int[] 
			tamanos = tamanosPerfectos(segun);
		
		boolean 
			esPer = PromocionPorcentual.class.isInstance(producto), 
			esAbs = PromocionAbsoluta.class.isInstance(producto), 
			esAxb = PromocionAxB.class.isInstance(producto),
			esPro = Promocion.class.isInstance(producto);
		
		String[] 
			unicPromo = (esPro) ? estadisticasDePromocion((Promocion) producto, segun) : new String[] { "", "" };
		
		String 
			nombre = Cadena.seleccion(producto.getNombre()).posicion("final").en(tamanos[0]),
			precio = Cadena.seleccion(String.valueOf(producto.getPrecio())).posicion("inicio").en(5),
			horas = Cadena.seleccion(String.valueOf(producto.getHoras())).posicion("inicio").en(4),
			cupos = Cadena.seleccion(String.valueOf(producto.getCupos())).posicion("inicio").en(4),
			tipo = Cadena.seleccion(producto.getTipo().toString()).posicion("inicio").en(11),
			promocion = Cadena.seleccion(unicPromo[1]).posicion("inicio").en((tamanos[2] < 10) ? 8 : tamanos[2]),
			contenido = Cadena.seleccion(unicPromo[0]).posicion("inicio").en(tamanos[1]),
			clase = Cadena.seleccion((esAbs) ? "<Absoluto>" : (esPer) ? "<Porcentual>" : (esAxb) ? "<AxB>" : "<Atraccion>").posicion("final").en(12);
		
		return "| " + nombre + " | " + tipo + " | " + precio + "p | " + horas + "h | " + cupos + "c | " + clase + " | "
				+ contenido + " | " + promocion + " | - (yes/no)";
	}

	private static String[] estadisticasDePromocion(Promocion producto, ArrayList<? extends Producto> segun) {

		//#indices o posiciones utiles
		int penultima = producto.getContenido().length - 2,
			ultima = producto.getContenido().length - 1;
		
		// #promocion absoluta // TODO: delegar a PromocionAbsoluta (class)
		int precioNoAbsoluto = 0;
		if (PromocionAbsoluta.class.isInstance(producto))
			for (Atraccion i : producto.getContenido())
				precioNoAbsoluto += i.getPrecio();

		String contenido = "";
		
		//#extra de la promocion
		boolean esAxB = PromocionAxB.class.isInstance(producto), esPorcentual = PromocionPorcentual.class.isInstance(producto);
		String promocion = (esAxB)
			? producto.getContenido() [ultima].getNombre() + " <gratis>"
			: (esPorcentual)
			? "%" + String.valueOf(((PromocionPorcentual) producto).getDescuento())
			: String.valueOf(precioNoAbsoluto) + " => " + String.valueOf(producto.getPrecio());

		//#contenido
		if (producto.getContenido().length > 1) {
			for (int i = 0; i < penultima; i++)
				contenido += producto.getContenido()[i].getNombre() + ", ";
			//#promocion axb
			if (PromocionAxB.class.isInstance(producto)) {
				contenido += producto.getContenido()[penultima].getNombre();
				promocion = producto.getContenido()[ultima].getNombre() + " <gratis>";
			} else {
				contenido += producto.getContenido()[penultima].getNombre() + ", ";
				contenido += producto.getContenido()[ultima].getNombre();
			}
		} else
			contenido = producto.getContenido()[0].getNombre();

		return new String[] { contenido, promocion };
	}

	private static void cartelito(ArrayList<? extends Producto> segun) {

		int[] tamanos = tamanosPerfectos(segun);
		System.out.println("| " + Cadena.seleccion("nombre").posicion("medio").en(tamanos[0])
				+ " |    tipo     | precio | horas | cupos |    clase     | "
				+ Cadena.seleccion("contenido").posicion("medio").en(tamanos[1]) + "  | "
				+ ((tamanos[2] < 10) ? "promocion" : Cadena.seleccion("promocion").posicion("medio").en(tamanos[2] + 1))
				+ " |");
	}

	private static int[] tamanosPerfectos(ArrayList<? extends Producto> segun) {

		ArrayList<Promocion> promos = new ArrayList<Promocion>();
		for (Producto i : segun)
			if (Promocion.class.isInstance(i))
				promos.add((Promocion) i);
		int largo = promos.toArray().length;
		
		String[] 
			atrac = new String[largo], 
			promo = new String[largo],
			nombres = Cadena.mapear(segun.toArray(), e -> ((Producto) e).getNombre());
		
		for (int i = 0; i < atrac.length; i++) {
			String[] contenido = Cadena.mapear(promos.get(i).getContenido(), e -> ((Atraccion) e).getNombre());
			atrac[i] = Cadena.seleccion(contenido).reduccion((acumulador, elem) -> acumulador + ", " + elem);
			promo[i] = estadisticasDePromocion(promos.get(i), segun)[1];
		}
		
		
		//#principal
			String 
				mayorNombre = Cadena.seleccion(nombres).reduccion((u, e) -> (u.length() < e.length()) ? e : u),
				mayorContenido = Cadena.seleccion(atrac).reduccion((u, e) -> (u.length() < e.length()) ? e : u),
				mayorPromocion = Cadena.seleccion(promo).reduccion((u, e) -> u.length() < e.length() ? e : u);
			
			return new int[] { mayorNombre.length(), mayorContenido.length(), mayorPromocion.length() };
	
	}

}
