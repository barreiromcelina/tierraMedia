package parque;

public abstract class Promocion extends Producto {
	
	private TipoPromo tipoPromo;

	public Promocion(String nombre, TipoAtraccion tipo, double costo, double tiempoPromedio, TipoPromo tipoPromo) {
		super(nombre, tipo, costo, tiempoPromedio);
		this.tipoPromo = tipoPromo;
	}
	
	public abstract double precioPromocional();

}
