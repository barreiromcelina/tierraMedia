package parque;

import java.util.Comparator;

import enums.TipoAtraccion;
import productos.Producto;

public class OrdenarSegunPreferencia implements Comparator<Producto> {

	private TipoAtraccion tipoPreferido;

	public OrdenarSegunPreferencia(TipoAtraccion tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

	@Override
	public int compare(Producto o1, Producto o2) {
		if (o1.getTipo() == this.tipoPreferido && o2.getTipo() == this.tipoPreferido) {
			if (o1.esPromo() && o2.esPromo()) {
				return comparadorCostoYtiempo(o1, o2);

			} else if (!o1.esPromo() && !o2.esPromo()) {
				return comparadorCostoYtiempo(o1, o2);
			
			}else {
				return -Boolean.compare(o1.esPromo(), o2.esPromo());

			}

		} else if (o1.getTipo() != this.tipoPreferido && o2.getTipo() != this.tipoPreferido) {
			if (o1.esPromo() && o2.esPromo()) {
				return comparadorCostoYtiempo(o1, o2);

			} else if (!o1.esPromo() && !o2.esPromo()) {
				return comparadorCostoYtiempo(o1, o2);

			} else {
				return -Boolean.compare(o1.esPromo(), o2.esPromo());
			}

		}else {
			if(o1.getTipo()==this.tipoPreferido) return -1;
			return 1;
		}
		
	}

	
	
	
	
	private int comparadorCostoYtiempo(Producto o1, Producto o2) {
		//Si los costos son iguales
		if (Double.compare(o1.getCosto(), o2.getCosto()) == 0) {
			//ordeno por tiempo de mayor a menor tiempo
			return -Double.compare(o1.getTiempoPromedio(), o2.getTiempoPromedio());

		} else {//sino ordeno de mayor a menor costo
			return -Double.compare(o1.getCosto(), o2.getCosto());
		}
	}

}
