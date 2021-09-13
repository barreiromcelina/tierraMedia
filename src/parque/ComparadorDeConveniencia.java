package parque;

import productos.*;
import enums.*;
import java.util.Comparator;

public class ComparadorDeConveniencia implements Comparator<Producto>{

	//#propiedades
	private TipoAtraccion preferenciaDeLaPersona;
	
	//#constructores
	public ComparadorDeConveniencia(TipoAtraccion preferenciaDeLaPersona) {
		this.preferenciaDeLaPersona = preferenciaDeLaPersona;
	}
	
	//metodos
	
	
	@Override
	public int compare(Producto productoAComparar, Producto comparando) {
		
		//#variables
		boolean[] sonDelTipo = new boolean[] {
			productoAComparar.getTipo().equals(preferenciaDeLaPersona), 
			comparando.getTipo().equals(preferenciaDeLaPersona)
		};
		boolean[] sonAtracciones = new boolean[] {
			Atraccion.class.isInstance(productoAComparar), 
			Atraccion.class.isInstance(comparando)
		};
	
		//#procesos
		return (sonDelTipo[0] == sonDelTipo[1])? 
					(sonAtracciones[0] == sonAtracciones[1])?  
						(productoAComparar.getPrecio() == comparando.getPrecio())? 
								-Double.compare(productoAComparar.getHoras(), comparando.getHoras()) 
						: -Integer.compare(productoAComparar.getPrecio(), comparando.getPrecio())
					:(sonAtracciones[0])? 1 : -1
				: -Boolean.compare(sonDelTipo[0], sonDelTipo[1]);
		
//		if(sonDelTipo[0] == sonDelTipo[1]) {
//			if(sonAtracciones[0] == sonAtracciones[1]) {
//				if(productoAComparar.getPrecio() == comparando.getPrecio())
//					return -Double.compare(productoAComparar.getHoras(), comparando.getHoras());
//				return -Integer.compare(productoAComparar.getPrecio(), comparando.getPrecio());				
//			} 
//			return -Boolean.compare(sonDelTipo[0], sonDelTipo[1]);
		//} 
		//return -Boolean.compare(sonDelTipo[0], sonDelTipo[1]);
	
	}
	
}
