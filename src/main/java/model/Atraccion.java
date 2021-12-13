package model;

public class Atraccion extends Producto {

	private Integer id;
	private Integer cupo;
	

	public Atraccion(Integer id, String nombre, double costo, TipoAtraccion tipo,
			int cupo, double tiempoPromedio) {
		super(nombre, tipo, costo, tiempoPromedio);
		this.id = id;
		this.cupo = cupo;
	
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public boolean hayCupo() {
		return this.cupo >= 1;
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
		return getNombre();
		
	}

	@Override
	public boolean contiene(Producto producto) {
		if(producto.esPromo()) {
			return producto.contiene(this);
		}
		return this.equals(producto);
	}
	
	
	
	
	
	
	
	
	

}
