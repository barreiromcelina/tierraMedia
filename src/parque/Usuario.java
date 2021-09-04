package parque;

import enums.TipoAtraccion;
import productos.Producto;

public class Usuario {

	private String nombre;
	private Double presupuesto;
	private Double tiempoDisponible;
	private TipoAtraccion tipoAtraccionPreferida;
	private Producto itinerario;
	
	public Usuario(String nombre, double presupuesto, double tiempoDisponible,
			TipoAtraccion tipoAtraccionPreferida, Producto itinerario) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoAtraccionPreferida = tipoAtraccionPreferida;
		this.itinerario = itinerario;
	}
	
	@Override
	public String toString() {
		return "Tipo Preferido: " + this.tipoAtraccionPreferida + " , Nombre: " + this.nombre+ " , Monedas de Oro: "+ this.presupuesto;
	}
	
	//aceptarLugar y descontar tiempoDisponible?
	
	

}
