package parque;

import java.util.ArrayList;

import enums.TipoAtraccion;
import productos.Atraccion;
import productos.Producto;
import productos.Promocion;

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

	protected String getNombre() {
		return nombre;
	}

	protected Double getPresupuesto() {
		return presupuesto;
	}

	protected Double getTiempoDisponible() {
		return tiempoDisponible;
	}

	protected TipoAtraccion getTipoAtraccionPreferida() {
		return tipoAtraccionPreferida;
	}
	
	public void comprar(Atraccion producto) {
		this.presupuesto-= producto.getCosto();
		this.tiempoDisponible-=producto.getTiempoPromedio();
		producto.ocuparUnLugar();
	}
	
	public void comprar(Promocion producto) {
		this.presupuesto-= producto.getCosto();
		this.tiempoDisponible-=producto.getTiempoPromedio();
		producto.ocuparUnLugar();
	}
	

	
	

}
