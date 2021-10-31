package parque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.ItinerarioDAOImpl;
import dao.UsuarioDAOImpl;
import enums.TipoAtraccion;
import productos.Atraccion;
import productos.Producto;
import productos.PromocionPorcentual;
import manejoArchivos.Escritor;
import manejoArchivos.Lector;
import productos.Promocion;

public class ParqueTierraMedia {

	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Producto> misProductos = new ArrayList<Producto>();

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

	public void ofrecerProducto(ArrayList<Usuario> misUsuarios) {

		Scanner sc = new Scanner(System.in);

		for (Usuario usuario : misUsuarios) {

			ArrayList<Producto> miItinerario = usuario.getItinerario();

			Collections.sort(this.misProductos, new OrdenarSegunPreferencia(usuario.getTipoAtraccionPreferida()));

			try {
				for (Producto producto : misProductos) {
					Boolean yaEsta = false;

					Iterator<Producto> itr = miItinerario.iterator();
					while (!yaEsta && itr.hasNext()) {
						yaEsta = itr.next().contiene(producto);
					}

					/*
					 * if (!producto.esPromo()) { yaEsta = miItinerario.contains(producto);}
					 * 
					 * if(producto.esPromo()) { for(Producto prod:
					 * ((Promocion)producto).getPromos()) { yaEsta |= miItinerario.contains(prod);
					 * 
					 * 
					 * } }
					 */

					if (usuario.getPresupuesto() < producto.getCosto()
							|| usuario.getTiempoDisponible() < producto.getTiempoPromedio() || yaEsta
							|| !producto.hayCupo()) {
						continue; // poner todo en negativo y entrar al metodo por aca

					}
					System.out.println(usuario.getNombre() + " (Presupuesto:" + usuario.getPresupuesto()
							+ " monedas | Tiempo disponible:" + usuario.getTiempoDisponible() + "h) \n \n"
							+ "Usted quiere comprar este producto? --> (y/n)" + "\n" + producto + "\t");

					String respuesta = sc.next();

					while (!respuesta.equalsIgnoreCase("y") && !respuesta.equalsIgnoreCase("n")) {
						System.out.println("Opcion inv�lida, ingrese 'y' o 'n' si quiere el producto");
						respuesta = sc.next();
					}

					if (respuesta.equalsIgnoreCase("y")) {
						usuario.comprar(producto);

						/*
						 * if (producto.esPromo()) { for (Atraccion atr : ((Promocion)
						 * producto).getPromos()) { miItinerario.add(atr); } }
						 */

						miItinerario.add(producto);

					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			usuario.setItinerario(miItinerario);
			Escritor.guardarItinerario(usuario);
			Escritor.guardarGasto(usuario);
			Escritor.guardarDuracion(usuario);
			
		}

		sc.close();

	}

}

