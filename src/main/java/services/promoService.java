package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.OrdenarSegunPreferencia;
import model.Producto;
import model.Usuario;
import persistence.commons.DAOFactory;

public class promoService {

	public List<Producto> obtenerAllPromos() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public Map<String, Producto> crearMapaAtraccion(ArrayList<Producto> misAtracciones) {

		Map<String, Producto> miMapaAtracciones = new HashMap<String, Producto>();

		for (Producto i : misAtracciones) {
			miMapaAtracciones.put(i.getNombre(), i);
		}
		return miMapaAtracciones;
	}
	public List<Producto> obtenerAllPromoOrdenadas(Usuario usuario, HashMap<String, Producto> misAtracciones) {
		List<Producto> promos = DAOFactory.getPromocionDAO().findAll(misAtracciones);
		Collections.sort(promos, new OrdenarSegunPreferencia(usuario.getTipoAtraccionPreferida()));
		return promos;
	}
	
}
