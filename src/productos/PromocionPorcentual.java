package productos;

import java.util.ArrayList;

import enums.TipoAtraccion;
import enums.TipoPromo;

public class PromocionPorcentual extends Promocion {

	private final TipoPromo tipoPromo = TipoPromo.PORCENTUAL;
	private double descuento;
	private String nombre;
	
	public PromocionPorcentual(ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo, double descuento) {
		super(promos, nombre, tipo);
		this.descuento= descuento;
		super.costo= this.getCosto();
		this.nombre= nombre;
	}

	@Override
	public Double getCosto() {
		return super.getCosto() * (1-this.descuento);
	}
	
	@Override 
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return getNombre()+ " {Descuento:" + descuento*100 + "%, Incluye:" + super.getNombre()
				+ ", Costo Promocional:" + getCosto() + ", Tiempo Promedio:" + getTiempoPromedio() + "}\n";
	}
	
	

}
