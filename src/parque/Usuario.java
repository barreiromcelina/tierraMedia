package parque;

import java.util.ArrayList;

import enums.TipoAtraccion;
import productos.Atraccion;
import productos.Producto;
import productos.Promocion;

public class Usuario {

	public  Double PRESUPUESTO_INICIAL;
	public  Double TIEMPO_INICIAL;
	private String nombre;
	private Double presupuesto;
	private Double tiempoDisponible;
	private TipoAtraccion tipoAtraccionPreferida;
	private ArrayList<Producto> itinerario = new ArrayList<Producto>();

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, TipoAtraccion tipoAtraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.PRESUPUESTO_INICIAL= presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.TIEMPO_INICIAL= tiempoDisponible;
		this.tipoAtraccionPreferida = tipoAtraccionPreferida;
	}

	@Override
	public String toString() {
		return "Tipo Preferido: " + this.tipoAtraccionPreferida + " , Nombre: " + this.nombre + " , Monedas de Oro: "
				+ this.presupuesto;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public Double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public TipoAtraccion getTipoAtraccionPreferida() {
		return tipoAtraccionPreferida;
	}

	public ArrayList<Producto> getItinerario() {
		return this.itinerario;
	}

	public void setItinerario(ArrayList<Producto> miItinerario) {
		this.itinerario = miItinerario;
	}

	public void comprar(Producto producto) {
		this.presupuesto -= producto.getCosto();
		this.tiempoDisponible -= producto.getTiempoPromedio();
		producto.ocuparUnLugar();
	}

	/*
	 * public void comprar(Promocion producto) { this.presupuesto-=
	 * producto.getCosto(); this.tiempoDisponible-=producto.getTiempoPromedio();
	 * producto.ocuparUnLugar(); }
	 */

}
