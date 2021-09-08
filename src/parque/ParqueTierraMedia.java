package parque;

import java.util.ArrayList;
import java.util.Collections;

import productos.Producto;

public class ParqueTierraMedia {

	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Producto> misProductos = new ArrayList<Producto>();

	public ParqueTierraMedia(ArrayList<Usuario> misUsuarios, ArrayList<Producto> promos,
			ArrayList<Producto> atracciones) {
		this.misUsuarios= misUsuarios;
		this.misProductos= misProductos(promos,atracciones); 

	}

	public ArrayList<Producto> misProductos(ArrayList<Producto> promos, ArrayList<Producto> atracciones) {
		
		ArrayList<Producto> listaProductos= new ArrayList<Producto>();
		 listaProductos.addAll(promos);
		 listaProductos.addAll(atracciones);
		
		return listaProductos;
	}
	
	public void misProductosOrdenadosPorPreferencia(Usuario usuario){
		Collections.sort(this.misProductos, new OrdenarSegunPreferencia(usuario.getTipoAtraccionPreferida()));
	}
	
	

}
