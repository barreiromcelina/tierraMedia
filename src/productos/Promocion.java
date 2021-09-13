package productos;


public class Promocion extends Producto {

	//#propiedades
	private Atraccion[] contenido;

	//constructores
	public Promocion() {
		super();
		this.contenido = new Atraccion[] {new Atraccion()};
	}
	
	//#obtenedores y modificadores
	public Atraccion[] getContenido() {
		return contenido;
	}

	public void setContenido(Atraccion[] contenido) {
		this.contenido = contenido;
	}
	
	public boolean esPromo() {
		return true;
	}
	
}