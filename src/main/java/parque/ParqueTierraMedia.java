package parque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import manejoArchivos.Escritor;
import model.OrdenarSegunPreferencia;
import model.Producto;
import model.Usuario;

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

		return listaProductos; //lo use en productoService
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
						yaEsta = itr.next().contiene(producto);   //lo puse en un metodo itinearioContiene en class Usuario
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

			//Setea el atributo Itinerario del usuario
			usuario.setItinerario(miItinerario);
			//Guarda el Itinerario en la Base de Datos
			Escritor.guardarItinerario(usuario);
			//Actualiza el Presupuesto y el tiempoDisponible del Usuario
			Escritor.actualizarUsuario(usuario);
			//Actualiza el cupo de las atraccioes del itinerario tanto sueltas como en Promociones
			Escritor.actualizarCupoDeAtraccion(miItinerario);
			
			
		}

		sc.close();

	}

	@Override
	public String toString() {
		return "ParqueTierraMedia [misUsuarios=" + misUsuarios + ", misProductos=" + misProductos + "]";
	}

}

