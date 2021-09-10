package productos;

import java.util.ArrayList;

import enums.TipoAtraccion;
import enums.TipoPromo;

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
		return getNombre()+ "Incluye:" + super.getNombre()+ "la última atracción es gratis!"
				+ ", Costo Promocional:" + getCosto() + ", Tiempo Promedio:" + getTiempoPromedio() + "]\n";
	}
	

}
