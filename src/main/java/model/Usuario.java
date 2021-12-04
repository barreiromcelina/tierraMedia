package model;

import java.util.ArrayList;

public class Usuario {

	public Double PRESUPUESTO_INICIAL;
	public Double TIEMPO_INICIAL;
	private String nombre;
	private Double presupuesto;
	private Double tiempoDisponible;
	private TipoAtraccion tipoAtraccionPreferida;
	private ArrayList<Producto> itinerario = new ArrayList<Producto>();

	public Usuario(String nombre, double presupuesto, double tiempoDisponible, TipoAtraccion tipoAtraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.PRESUPUESTO_INICIAL = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.TIEMPO_INICIAL = tiempoDisponible;
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
	
	public String stringItineario() {
		String nombres="";
		for (Producto p : itinerario) {
			if (p.esPromo()) {
				 nombres += "  - "+p.getNombre() + " (" + p.getNombreEnPromo() + ")" + "\n";
			} else {
				 nombres += "  - "+p.getNombre() +"\n";
			}

		}
		return nombres;

	}

	public void setItinerario(ArrayList<Producto> miItinerario) {
		this.itinerario = miItinerario;
	}

	public void comprar(Producto producto) {
		this.presupuesto -= producto.getCosto();
		this.tiempoDisponible -= producto.getTiempoPromedio();
		producto.ocuparUnLugar();
	}

}
