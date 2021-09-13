package productos;

import enums.TipoAtraccion;

public class Producto {
	
	//#propiedades
	private String nombre;
	private TipoAtraccion tipo;
	private int precio, cupos;
	private double horas;
	
	//#constructores
	public Producto() {
		this.nombre = null;
		this.tipo = null;
		this.precio = 0;
		this.cupos = 0;
		this.horas = 0.0d;
	}
	
	//#obtenedores y modificadores
	public String getNombre() {
		return nombre;
	}
	public Producto setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	public TipoAtraccion getTipo() {
		return tipo;
	}
	public Producto setTipo(TipoAtraccion tipo) {
		this.tipo = tipo;
		return this;
	}
	public int getPrecio() {
		return this.precio;
	}
	public Producto setPrecio(int precio) {
		this.precio = precio;
		return this;
	}
	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}
	public double getHoras() {
		return horas;
	}
	public Producto setHoras(double horas) {
		this.horas = horas;
		return this;
	}
	
	//#metodos
	
	@Override
	public String toString() {
		return String.format("{ nombre:%s, tipo:%s, precio:%s, cupos:%s, horas:%s }", this.nombre, this.tipo, this.precio, this.cupos, this.horas);
	}

} // 


