package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import utils.Crypt;

public class Usuario {

	private int id;
	private boolean admin;
	public Double PRESUPUESTO_INICIAL;
	public Double TIEMPO_INICIAL;
	private String nombre, password;
	private Double presupuesto;
	private Double tiempoDisponible;
	private TipoAtraccion tipoAtraccionPreferida;
	private ArrayList<Producto> itinerario= new ArrayList<Producto>();
	private double gastoAcumulado;
	private double tiempoAcumulado;
	private Map<String, String> errors;

	public Usuario(int id, boolean admin, String nombre, String password, double presupuesto, 
			double tiempoDisponible, TipoAtraccion tipoAtraccionPreferida) {
		super();
		this.id = id;
		this.admin = admin;
		this.nombre = nombre;
		this.password = password;
		this.presupuesto = presupuesto;
		this.PRESUPUESTO_INICIAL = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.TIEMPO_INICIAL = tiempoDisponible;
		this.tipoAtraccionPreferida = tipoAtraccionPreferida;
	}

	public int getId() {
		return id;
	}

	public double getGastoAcumulado() {
		return gastoAcumulado;
	}

	public double getTiempoAcumulado() {
		return tiempoAcumulado;
	}

	public void setGastoAcumulado(double gastoAcumulado) {
		this.gastoAcumulado = gastoAcumulado;
	}

	public void setTiempoAcumulado(double tiempoAcumulado) {
		this.tiempoAcumulado = tiempoAcumulado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Crypt.hash(password);
	}
	
	public boolean checkPassword(String password) {
		// this.password en realidad es el hash del password
		return Crypt.match(password, this.password);
	}

	@Override
	public String toString() {
		return "Tipo Preferido: " + this.tipoAtraccionPreferida + " , Nombre: " + this.nombre + " , Monedas de Oro: "
				+ this.presupuesto;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String setNombre(String nombre) {
		return this.nombre = nombre;
	}
	
	public int getAdminInteger() {
		if(isAdmin()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public Boolean isAdmin() {
		return admin;
	}

	public boolean isNull() {
		return false;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public Double getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public boolean puedePagar(Producto producto) {
		return this.getPresupuesto() >= producto.getCosto();
	}

	public boolean tieneTiempo(Producto producto) {
		return this.getTiempoDisponible() >= producto.getTiempoPromedio();
	}
	
	public TipoAtraccion getTipoAtraccionPreferida() {
		return tipoAtraccionPreferida;
	}

	public ArrayList<Producto> getItinerario() {
		return this.itinerario;
	}
	
	public String stringItineario() {
		String nombres="";
		for (Producto p : itinerario) {
			if (p.esPromo()) {
				 nombres += "  - "+p.getNombre() + " (" + p.getNombreEnPromo() + ")" + "\n";
			} else {
				 nombres += "  - "+p.getNombre() +"\n";
			}
		}
		return nombres;
	}

	public void setItinerario(ArrayList<Producto> miItinerario) {
		this.itinerario = miItinerario;
	}

	public void comprar(Producto producto) {
		this.presupuesto -= producto.getCosto();
		this.tiempoDisponible -= producto.getTiempoPromedio();
		this.gastoAcumulado += producto.getCosto();
		this.tiempoAcumulado += producto.getTiempoPromedio();
		producto.ocuparUnLugar();
	}
	
	public boolean itinerarioContiene(Producto p) {
		Boolean yaEsta = false;

		Iterator<Producto> itr = itinerario.iterator();
		while (!yaEsta && itr.hasNext()) {
			yaEsta = itr.next().contiene(p);
		}
		return yaEsta;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (presupuesto <= 0) {
			errors.put("Presupuesto", "Debe ser mayor a cero");
		}
		if (tiempoDisponible <= 0) {
			errors.put("Tiempo", "Debe ser mayor a cero");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	


}
