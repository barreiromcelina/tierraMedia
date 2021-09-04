package productos;

import java.util.ArrayList;

import enums.TipoAtraccion;
import enums.TipoPromo;

public class PromocionAxB extends Promocion {
	
	private final TipoPromo tipoPromo = TipoPromo.A_X_B;

	public PromocionAxB(ArrayList<Atraccion> promos, String nombre, TipoAtraccion tipo) {
		super(promos, nombre, tipo);
	}

	@Override
	public double precioPromocional() {
		return super.getCosto() - promos.get(promos.size()-1).getCosto();
	}
	

}
