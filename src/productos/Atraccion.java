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
	
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	@Override
	public void ocuparUnLugar() {
		this.cupo--;
	}
	
	
	
	

}
