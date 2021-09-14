package productos;

import java.util.Objects;

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
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract boolean hayCupo(); 

	public abstract void ocuparUnLugar();
	
	public abstract boolean contiene(Producto producto);

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
		

}
