package parque;

public abstract class Producto {
	 
	private String nombre;
	 protected TipoAtraccion tipo;
	 protected Double costo;
	 protected Double tiempoPromedio;
	
	
	 public Producto(String nombre, TipoAtraccion tipo, double costo, double tiempoPromedio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.tiempoPromedio = tiempoPromedio;
	}
	 	 
	 public boolean esPromo() {
		 return false;	 
	 }
	 
	 public abstract void comparadorSugerencias();

	}

