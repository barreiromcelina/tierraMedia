package parque;

public class Atraccion {

	private String nombre;
	private double costo;
	private TipoAtraccion tipo;
	private int cupo;
	private double tiempoPromedio;
	private int cuantoOcupados;

	public Atraccion(String nombre, double costo, TipoAtraccion tipo,
			int cupo, double tiempoPromedio) {
		this.nombre = nombre;
		this.costo = costo;
		this.tipo = tipo;
		this.cupo = cupo;
		this.tiempoPromedio = tiempoPromedio;
	}
	
	public boolean hayCupo() {
		return this.cuantoOcupados<this.cupo;
	}
	
	public void ocuparUnLugar() {
		this.cuantoOcupados++;
	}
	
	
	
	

}
