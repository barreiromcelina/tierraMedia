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
		return comparadorPreferencia(o1,o2);
	}

	private int comparadorPreferencia(Producto o1, Producto o2) {
		//Si ambos son de su preferencia
		if (o1.getTipo() == this.tipoPreferido && o2.getTipo() == this.tipoPreferido) {
			//Voy a comparar si son promociones o atracciones sueltas
			return comparadorProducto(o1,o2);
		
		//Si ambos no son de su preferencia
		}else if (o1.getTipo() != this.tipoPreferido && o2.getTipo() != this.tipoPreferido) {
			//Voy a comparar si son promociones o atracciones sueltas
			return comparadorProducto(o1,o2);
			
		} else {
			//Si un producto es preferido y el otro no. Ubico promero el preferido y despues el no preferido
			if(o1.getTipo()==this.tipoPreferido) return -1;
			return 1;
		}
	}
	
	private int comparadorProducto(Producto o1, Producto o2) {
		//Si ambas son promos
		if (o1.esPromo() && o2.esPromo()) {
			//voy a comparar costo y tiempo
			return comparadorCostoYtiempo(o1, o2);
			
		//sino, miro si ambas son atracciones sueltas
		} else if (!o1.esPromo() && !o2.esPromo()) {
			//voy a comparar costo y tiempo
			return comparadorCostoYtiempo(o1, o2);
			
		} else {//Sino ubico la promo primero y luego la atraccion
			return -Boolean.compare(o1.esPromo(), o2.esPromo());
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
