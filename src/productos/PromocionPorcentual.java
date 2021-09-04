package productos;

import java.util.ArrayList;

import enums.TipoAtraccion;
import enums.TipoPromo;

public class PromocionPorcentual extends Promocion {

	private final TipoPromo tipoPromo = TipoPromo.PORCENTUAL;
	private double descuento;
	
	public PromocionPorcentual(ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo, double descuento) {
		super(promos, nombre, tipo);
		this.descuento= descuento;
		super.costo= this.precioPromocional();
	}

	@Override
	public double precioPromocional() {
		return super.getCosto() * (1-this.descuento);
	}

}
