package productos;

import java.util.ArrayList;

import enums.TipoAtraccion;
import enums.TipoPromo;

public class PromocionAbsoluta extends Promocion {

	private double precioFinal;
	private final TipoPromo tipoPromo = TipoPromo.ABSOLUTA;

	public PromocionAbsoluta(ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo, double precioFinal) {
		super(promos, nombre, tipo);
		super.costo= precioFinal;

	}

	@Override
	public Double getCosto() {
		return this.costo;
	}

}
