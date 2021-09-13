package productos;

public class PromocionPorcentual extends Promocion {

	private double descuento;
	
	public double getDescuento() {
		return descuento;
	}
	public PromocionPorcentual setDescuento(double nuevoDescuento) {
		this.descuento = nuevoDescuento;
		return this;
	}
	
}