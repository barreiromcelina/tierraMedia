package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import model.OrdenarSegunPreferencia;
import model.Producto;
import model.Usuario;

public class productoService {

	public List<Producto> obtenerTodoOrdenado(Usuario usuario) throws SQLException {
		
		atraccionService aService = new atraccionService();
		promoService pService= new promoService();
		
		List<Producto> atracciones = aService.obtenerAllAtracciones();
		List<Producto> promos = pService.obtenerAllPromoOrdenadas(usuario, (HashMap<String, Producto>)pService.crearMapaAtraccion());
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.addAll(promos);
		listaProductos.addAll(atracciones);
		Collections.sort(listaProductos, new OrdenarSegunPreferencia(usuario.getTipoAtraccionPreferida()));

		return listaProductos;
		
	}

}
