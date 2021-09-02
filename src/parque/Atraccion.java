package parque;

public class Atraccion extends Producto {

	private int cupo;
	private int cuantoOcupados;

	public Atraccion(String nombre, double costo, TipoAtraccion tipo,
			int cupo, double tiempoPromedio) {
		super(nombre, tipo, costo, tiempoPromedio);
		this.cupo = cupo;
	
	}
	
	public boolean hayCupo() {
		return this.cuantoOcupados<this.cupo;
	}
	
	public void ocuparUnLugar() {
		this.cuantoOcupados++;
	}
	
	
	
	

}
