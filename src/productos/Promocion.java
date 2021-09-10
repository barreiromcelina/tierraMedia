package productos;

import java.util.ArrayList;

import enums.TipoAtraccion;

public abstract class Promocion extends Producto {

	protected ArrayList<Atraccion> promos;

	public Promocion(ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo) {
		super(nombre, tipo, 0, 0);
		this.promos = promos;
		super.costo = this.getCosto();
		super.tiempoPromedio = this.getTiempoPromedio();
	}

	public Double getCosto() {
		double costo = 0;
		for (Atraccion atraccion : promos)
			costo += atraccion.getCosto();
		return costo;
	}

	public Double getTiempoPromedio() {
		double tiempo = 0;
		for (Atraccion atraccion : promos)
			tiempo += atraccion.getTiempoPromedio();
		return tiempo;
	}

	@Override
	public boolean esPromo() {
		return true;
	}

	@Override
	public void ocuparUnLugar() {
		for (Atraccion atraccion : promos) {
		atraccion.ocuparUnLugar();
	
		}
	}
	
	@Override 
	public String getNombre() {
		String nombres="";
		for (Atraccion atraccion : promos) {
			nombres += atraccion.getNombre()+ " ";			
		}
		return nombres;
	}

	
	

}
