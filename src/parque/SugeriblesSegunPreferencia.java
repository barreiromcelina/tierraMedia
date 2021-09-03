package parque;

import java.util.Comparator;

public class SugeriblesSegunPreferencia implements Comparator<Producto> {

	private TipoAtraccion tipoPreferido;

	public SugeriblesSegunPreferencia(TipoAtraccion tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		if (o1.tipo == this.tipoPreferido && o2.tipo == this.tipoPreferido) {
			if (o1.esPromo() && o2.esPromo()) {
				if (Double.compare(o1.costo, o2.costo) == 0) {
					return -Double.compare(o1.tiempoPromedio, o2.tiempoPromedio);

				} else {
					return -Double.compare(o1.costo, o2.costo);
				}
				
			}

		}
		return 0;
	}

}
