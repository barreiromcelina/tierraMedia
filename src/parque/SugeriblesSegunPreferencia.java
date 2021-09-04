package parque;

import java.util.Comparator;

import enums.TipoAtraccion;
import productos.Producto;

public class SugeriblesSegunPreferencia implements Comparator<Producto> {

	private TipoAtraccion tipoPreferido;

	public SugeriblesSegunPreferencia(TipoAtraccion tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		if (o1.getTipo() == this.tipoPreferido && o2.getTipo() == this.tipoPreferido) {
			if (o1.esPromo() && o2.esPromo()) {
				if (Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
					return -Double.compare(o1.getTiempoPromedio(), o2.getTiempoPromedio());

				} else {
					return -Double.compare(o1.getCosto(), o2.getCosto());
				}
				
			}//falta codigo

		}
		return 0;
	}

}
