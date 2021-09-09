package parque;

import java.util.ArrayList;
import java.util.Collections;

import enums.TipoAtraccion;
import productos.Atraccion;
import productos.Producto;
import productos.PromocionPorcentual;

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

	public void misProductosOrdenadosPorPreferencia(Usuario usuario) {
		Collections.sort(this.misProductos, new OrdenarSegunPreferencia(usuario.getTipoAtraccionPreferida()));
	}

	public static void main(String[] args) {
		Atraccion atraccion1 = new Atraccion("Moria", 10, TipoAtraccion.AVENTURA, 6, 2);
		Atraccion atraccion2 = new Atraccion("Mordor", 25, TipoAtraccion.AVENTURA, 4, 3);
		Atraccion atraccion3 = new Atraccion("Monta", 15, TipoAtraccion.AVENTURA, 5, 3);
		Atraccion atraccion4 = new Atraccion("Minas Tirith", 5, TipoAtraccion.PAISAJE, 25, 2.5);
		Atraccion atraccion5 = new Atraccion("Abismos de Helm", 5, TipoAtraccion.PAISAJE, 15, 2);
		
		ArrayList<Atraccion> arrayAventura= new ArrayList<Atraccion>();
		ArrayList<Atraccion> arrayPaisaje= new ArrayList<Atraccion>();
		
		arrayAventura.add(atraccion1);
		arrayAventura.add(atraccion2);
		arrayPaisaje.add(atraccion4);
		arrayPaisaje.add(atraccion5);
		
		Producto promoAventura = new PromocionPorcentual(arrayAventura, "Pack Aventura", TipoAtraccion.AVENTURA, 0.2);
		Producto promoPaisaje = new PromocionPorcentual(arrayPaisaje, "Pack Paisaje", TipoAtraccion.PAISAJE, 0.1);
		
		ArrayList<Producto> misProductos= new ArrayList<Producto>();
		
		misProductos.add(promoAventura);
		misProductos.add(promoPaisaje);
		misProductos.add(atraccion1);
		misProductos.add(atraccion2);
		misProductos.add(atraccion3);
		misProductos.add(atraccion4);
		misProductos.add(atraccion5);
		
		Collections.sort(misProductos, new OrdenarSegunPreferencia(TipoAtraccion.AVENTURA));
		
		System.out.println(misProductos);
		System.out.println("--------------------");
        Collections.sort(misProductos, new OrdenarSegunPreferencia(TipoAtraccion.PAISAJE));
		
		System.out.println(misProductos);
	}

}
