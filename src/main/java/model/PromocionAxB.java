package model;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {
	
	private final TipoPromo tipoPromo = TipoPromo.A_X_B;
	private String nombre;

	public PromocionAxB(ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo) {
		super(promos, nombre, tipo);
		this.nombre= nombre;
	}

	@Override
	public Double getCosto() {
		return super.getCosto() - promos.get(promos.size()-1).getCosto();
	}
	
	@Override 
	public String getNombre() {
		return this.nombre;
	}
	@Override
	public String toString() {
		return getNombre()+ " {Incluye:" + super.getNombreEnPromo()+ "�la �ltima atracci�n es gratis!"
				+ ", Costo Promocional:" + getCosto() + " monedas, Tiempo:" + getTiempoPromedio() + "h}\n";
	}
	

}
