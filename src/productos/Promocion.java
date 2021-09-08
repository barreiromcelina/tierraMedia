package productos;

import java.util.ArrayList;

import Turismo.Atraccion;
import enums.TipoAtraccion;

public abstract class Promocion extends Producto {

	protected ArrayList<Atraccion> atracciones;

	public Promocion(ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo) {
		super(nombre, tipo, 0, 0);
		this.atracciones = promos;
		super.costo = this.getCosto();
		super.tiempoPromedio = this.getTiempoPromedio();
	}

	public Double getCosto() {
		double costo = 0;
		for (Atraccion atraccion : atracciones)
			costo += atraccion.getCosto();
		return costo;
	}

	public Double getTiempoPromedio() {
		double tiempo = 0;
		for (Atraccion atraccion : atracciones)
			tiempo += atraccion.getTiempoPromedio();
		return tiempo;
	}

	public abstract double precioPromocional();

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}
	
	@Override
	public boolean esPromo() {
		return true;
	}
	
	

}
