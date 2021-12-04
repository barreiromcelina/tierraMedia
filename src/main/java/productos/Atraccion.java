package productos;

import enums.TipoAtraccion;

public class Atraccion extends Producto {

	private Integer cupo;
	

	public Atraccion(String nombre, double costo, TipoAtraccion tipo,
			int cupo, double tiempoPromedio) {
		super(nombre, tipo, costo, tiempoPromedio);
		this.cupo = cupo;
	
	}
	
	public boolean hayCupo() {
		return this.cupo>0;
	}
	
	public Integer getCupo() {
		return this.cupo;
	}

	@Override
	public void ocuparUnLugar() {
		this.cupo--;
	}

	@Override
	public String toString() {
		return getNombre()+ " {Costo:" + getCosto() + " monedas, Tiempo:" + getTiempoPromedio()
			+ "h, Tipo: " + getTipo().toString().toLowerCase() + "}"+ "\n";
		
	}

	@Override
	public boolean contiene(Producto producto) {
		if(producto.esPromo()) {
			return producto.contiene(this);
		}
		return this.equals(producto);
	}
	
	
	
	
	
	
	

}
