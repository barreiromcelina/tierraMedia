package parque;

import java.util.ArrayList;

import enums.TipoAtraccion;
import productos.Producto;

public class Usuario {

	private String nombre;
	private Double presupuesto;
	private Double tiempoDisponible;
	private TipoAtraccion tipoAtraccionPreferida;
	private ArrayList<Producto> itinerario = new ArrayList<Producto>();
	
	public Usuario(String nombre, double presupuesto, double tiempoDisponible,
			TipoAtraccion tipoAtraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoAtraccionPreferida = tipoAtraccionPreferida;
	}
	
	@Override
	public String toString() {
		return "Tipo Preferido: " + this.tipoAtraccionPreferida + " , Nombre: " + this.nombre+ " , Monedas de Oro: "+ this.presupuesto;
	}
	
	//aceptarLugar y descontar tiempoDisponible?
	
	

}
