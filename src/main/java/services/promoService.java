package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Atraccion;
import model.OrdenarSegunPreferencia;
import model.Producto;
import model.Promocion;
import model.TipoAtraccion;
import model.TipoPromo;
import model.Usuario;
import model.nullobjects.NullAtr;
import persistence.commons.DAOFactory;

public class promoService {

	public List<Producto> obtenerAllPromos() {
		return DAOFactory.getPromocionDAO().findAll();
	}

	public Map<String, Producto> crearMapaAtraccion() {

		atraccionService aService = new atraccionService();
		List<Producto> misAtracciones = aService.obtenerAllAtracciones();
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

	public void borrar(Integer id) {
		Atraccion atr = (Atraccion) DAOFactory.getAtraccionDAO().find(id);
		DAOFactory.getPromocionDAO().delete(atr);
		
	}

	public void borrarPromo(Integer id) {
		DAOFactory.getPromocionDAO().deletePromo(id);
		
	}
	
	public ArrayList<String> traerTiposAtraccion() {
		List<TipoAtraccion> tiposAtraccion = new ArrayList<TipoAtraccion>();
		tiposAtraccion = Arrays.asList(TipoAtraccion.values());
		ArrayList<String> tiposAtraccionString = new ArrayList<String>();

		for (int i = 0; i < tiposAtraccion.size(); i++) {
			tiposAtraccionString.add(tiposAtraccion.get(i).toString());
		}

		return tiposAtraccionString;
		
	}
	
	public ArrayList<String> traerTiposPromocion() {
		List<TipoPromo> tiposPromo = new ArrayList<TipoPromo>();
		tiposPromo = Arrays.asList(TipoPromo.values());
		ArrayList<String> tiposAtraccionString = new ArrayList<String>();

		for (int i = 0; i < tiposPromo.size(); i++) {
			tiposAtraccionString.add(tiposPromo.get(i).toString());
		}

		return tiposAtraccionString;
		
	}
	
	public Promocion find(Integer pId) {
		HashMap<String, Producto> mapaAtracciones = (HashMap<String, Producto>) this.crearMapaAtraccion();
		return (Promocion) DAOFactory.getPromocionDAO().find(mapaAtracciones, pId);
	}

	public Promocion update(Integer id, String nombre, TipoPromo tipo, Double valor, String[] atrEnPromo) {
		Promocion promocion = this.find(id);
		
		promocion.setNombre(nombre);
		promocion.setValor(valor);
		promocion.setTipoPromo(tipo);
		
		ArrayList<Atraccion> atrEnLaPromo = new ArrayList<Atraccion>();
		HashMap<String, Producto> misAtracciones = (HashMap<String, Producto>) this.crearMapaAtraccion();

		for (String s : atrEnPromo) {

			Atraccion unAtr = (Atraccion) misAtracciones.get(s);
			if (unAtr == null) {
				unAtr = NullAtr.build();
			} else {
				atrEnLaPromo.add(unAtr); // mi array de atracciones que es un atributo de la clase
			} // Promocion
		}
		
		promocion.setPromos(atrEnLaPromo);
		DAOFactory.getPromocionDAO().update(promocion);
		return promocion;
		
	}

	public void create(String nombre, TipoPromo tipo, Double valor, String[] atrEnPromo, TipoAtraccion tipoAtr) {
		ArrayList<Atraccion> atrEnLaPromo = new ArrayList<Atraccion>();
		HashMap<String, Producto> misAtracciones = (HashMap<String, Producto>) this.crearMapaAtraccion();
		for (String s : atrEnPromo) {

			Atraccion unAtr = (Atraccion) misAtracciones.get(s);
			if (unAtr == null) {
				unAtr = NullAtr.build();
			} else {
				atrEnLaPromo.add(unAtr); // mi array de atracciones que es un atributo de la clase
			} // Promocion
		}
		Promocion promocion = new Promocion(-1, atrEnLaPromo, nombre, tipoAtr);
		promocion.setTipoPromo(tipo);
		promocion.setValor(valor);
		DAOFactory.getPromocionDAO().insert(promocion);
		
	}
	
	
	
}
