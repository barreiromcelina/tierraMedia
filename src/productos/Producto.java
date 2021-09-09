package productos;

import enums.TipoAtraccion;

public abstract class Producto {

	private String nombre;
	private TipoAtraccion tipo;
	protected Double costo;
	protected Double tiempoPromedio;

	public Producto(String nombre, TipoAtraccion tipo, double costo, double tiempoPromedio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.tiempoPromedio = tiempoPromedio;
	}

	public boolean esPromo() {
		return false;
	}

	public Double getCosto() {
		return this.costo;
	}

	public Double getTiempoPromedio() {
		return this.tiempoPromedio;
	}

	public TipoAtraccion getTipo() {
		return this.tipo;
	}
	
	protected String getNombre() {
		return this.nombre;
	}

	public abstract void ocuparUnLugar();

}
