package productos;

import java.util.ArrayList;

import enums.TipoAtraccion;
import enums.TipoPromo;

public class PromocionAbsoluta extends Promocion {

	private double precioFinal;
	private final TipoPromo tipoPromo = TipoPromo.ABSOLUTA;
	private String nombre;

	public PromocionAbsoluta(ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo, double precioFinal) {
		super(promos, nombre, tipo);
		super.costo= precioFinal;
		this.nombre= nombre;

	}

	@Override
	public Double getCosto() {
		return this.costo;
	}

	@Override 
	public String getNombre() {
		return this.nombre;
	}
	@Override
	public String toString() {
		return getNombre()+ " {Incluye:" + super.getNombre()+
			", Costo Promocional:" + getCosto() + " monedas, Tiempo:" + getTiempoPromedio() + "h}\n";
	}
	
	

}
