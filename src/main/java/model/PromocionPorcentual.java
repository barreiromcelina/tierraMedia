package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PromocionPorcentual extends Promocion {

	private final TipoPromo tipoPromo = TipoPromo.PORCENTUAL;
	private double descuento;
	private String nombre;


	public PromocionPorcentual( Integer id,ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo, double descuento) {
		super(id, promos, nombre, tipo);
		this.descuento = descuento;
		super.costo = this.getCosto();
		this.nombre = nombre;
	}
	
	
	public TipoPromo getTipoPromo() {
		return tipoPromo;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public Double getCosto() {
		return super.getCosto() * (1 - this.descuento);
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return getNombre() + " {Incluye:" + super.getNombreEnPromo() + "Descuento:" + descuento * 100 + "%, Costo Promocional:"
				+ getCosto() + " monedas, Tiempo:" + getTiempoPromedio() + "h}\n";
	}
	
	@Override
	public void validate() {
		super.validate();

		if (descuento <= 0 || descuento >=1) {
			errors.put("Descuento", "Debe tener valores entre 0 y 1");
		}
	}
	

}
