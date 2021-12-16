package model;

import java.util.HashMap;
import java.util.Map;

public class Atraccion extends Producto {

	private Integer id;
	private Integer cupo;
	private Map<String, String> errors;

	public Atraccion(Integer id, String nombre, double costo, TipoAtraccion tipo,
			int cupo, double tiempoPromedio) {
		super(nombre, tipo, costo, tiempoPromedio);
		this.id = id;
		this.cupo = cupo;
	
	}
	
	
	
	public void setId(Integer id) {
		this.id = id;
	}



	public void setCupo(Integer cupo) {
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
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (costo <= 0) {
			errors.put("Costo", "Debe ser mayor a cero");
		}
		if (tiempoPromedio <= 0) {
			errors.put("Tiempo", "Debe ser mayor a cero");
		}
		if (cupo <= 0) {
			errors.put("Cupo", "Debe ser mayor a cero");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	
	
	
	
	
	
	

}
