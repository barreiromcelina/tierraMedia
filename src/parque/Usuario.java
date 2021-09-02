package parque;

public class Usuario {
	private int id;
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private TipoAtraccion tipoAtraccionPreferida;
	private Producto itinerario;
	public Usuario(int id, String nombre, double presupuesto, double tiempoDisponible,
			TipoAtraccion tipoAtraccionPreferida, Producto itinerario) {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoAtraccionPreferida = tipoAtraccionPreferida;
		this.itinerario = itinerario;
	}
	
	@Override
	public String toString() {
		return "Tipo Preferido: " + this.tipoAtraccionPreferida + " , Nombre: " + this.nombre+ " , Monedas de Oro: "+ this.presupuesto;
	}
	
	
	

}
