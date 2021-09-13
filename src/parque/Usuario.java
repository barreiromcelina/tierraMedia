package parque;


import enums.TipoAtraccion;
import productos.*;
import java.util.ArrayList;

public class Usuario {

	//#propiedades
	private String nombre;
	private TipoAtraccion preferencia;
	private int presupuesto;
	private double horas;
	private ArrayList<Producto> itinerario;
	
	//#constructores
	public Usuario() {
		this.nombre = null;
		this.preferencia = null;
		this.presupuesto = 0;
		this.horas = 0.0d;
		this.itinerario = new ArrayList<Producto>();
	}
	
	//#obtenedores y modificadores
	public String getNombre() {
		return nombre;
	}
	public Usuario setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	
	public TipoAtraccion getPreferencia() {
		return preferencia;
	}
	public Usuario setPreferencia(TipoAtraccion preferencia) {
		this.preferencia = preferencia;
		return this;
	}
	
	public int getPresupuesto() {
		return presupuesto;
	}
	public Usuario setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
		return this;
	}
	
	public double getHoras() {
		return horas;
	}
	public Usuario setHoras(double horas) {
		this.horas = horas;
		return this;
	}
	
	public ArrayList<Producto> getItinerario() {
		return itinerario;
	}
	public Usuario setItinerario(ArrayList<Producto> itinerario) {
		this.itinerario = itinerario;
		return this;
	}
	
	//#metodos
	
	@Override
	public String toString() {
		return String.format("{ nombre:%s, preferencia:%s, presupuesto:%s, horas:%s }", this.nombre, this.preferencia, this.presupuesto, this.horas);
	}
	
}