package parque;

import java.util.ArrayList;
import java.util.Collections;

import enums.TipoAtraccion;
import productos.Atraccion;
import productos.Producto;
import productos.Promocion;

public class Usuario {

	private String nombre;
	private Double presupuesto;
	private Double tiempoDisponible;
	private TipoAtraccion tipoAtraccionPreferida;
	private ArrayList<Producto> itinerario = new ArrayList<Producto>();
	
	
	private ArrayList<Atraccion> atraccionesConPreferencias = new ArrayList<Atraccion>();
	private ArrayList<Atraccion> atraccionesSinPrefenecias = new ArrayList<Atraccion>();
	private ArrayList<Atraccion> atraccionesCompradas = new ArrayList<Atraccion>();
	
	private ArrayList<Promocion> promocionesConPreferencias = new ArrayList<Promocion>();
	private ArrayList<Promocion> promocionesSinPreferencias = new ArrayList<Promocion>();
	private ArrayList<Promocion> promocionesCompradas = new ArrayList<Promocion>();
	
	public Usuario(String nombre, double presupuesto, double tiempoDisponible,
			TipoAtraccion tipoAtraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoAtraccionPreferida = tipoAtraccionPreferida;
	}
	
	@Override
	public String toString() {
		return "Tipo Preferido: " + this.tipoAtraccionPreferida + " , Nombre: " + this.nombre+ " , Monedas de Oro: "+ this.presupuesto;
	}

	protected String getNombre() {
		return nombre;
	}

	protected Double getPresupuesto() {
		return presupuesto;
	}

	protected Double getTiempoDisponible() {
		return tiempoDisponible;
	}

	protected TipoAtraccion getTipoAtraccionPreferida() {
		return tipoAtraccionPreferida;
	}
	
	public void comprar(Atraccion producto) {
		this.presupuesto-= producto.getCosto();
		this.tiempoDisponible-=producto.getTiempoPromedio();
		producto.ocuparUnLugar();
	}
	
	public void comprar(Promocion producto) {
		this.presupuesto-= producto.precioPromocional();
		this.tiempoDisponible-=producto.getTiempoPromedio();
		//cupo -- en la atracion? o un metodo vender atraccion/promo que haga cupo-- en cada
	}
	
	
	//aceptarLugar y descontar tiempoDisponible?
	
	//--------------------------------------------------------------------------
	
	public void sugerirOpciones(ArrayList<Atraccion> listaAllAtracciones, ArrayList<Promocion> listaAllPromociones) {
		boolean controller = true;
		
		for (Atraccion atraccion : listaAllAtracciones) {
			if(atraccion.getTipo().equals(this.getTipoAtraccionPreferida()) && atraccion.getCosto() <= this.getPresupuesto() 
					&& atraccion.getTiempoPromedio() <= this.getTiempoDisponible() ) {	
				getAtraccionesConPreferencias().add(atraccion);			
			}else {
				getAtraccionesSinPrefenecias().add(atraccion);
			}

		}
		
		for (Promocion promocion : listaAllPromociones) {
			for (Atraccion atraccion : promocion.getAtracciones()) {
				if(atraccion.getTipo().equals(this.getTipoAtraccionPreferida()) && controller == true ) {
					getPromocionesConPreferencias().add(promocion);
					controller=false;
				}
			}	
			if(controller == true ) {
				getPromocionesSinPreferencias().add(promocion);
			} 
			controller=true;
		}

		//ORDENA DE MAYOR A MENOR, POR PRECIO
		Collections.sort(getAtraccionesSinPrefenecias(), Collections.reverseOrder()); 	
		Collections.sort(getAtraccionesConPreferencias(), Collections.reverseOrder());
		
	
	}

	public ArrayList<Atraccion> getAtraccionesSinPrefenecias() {
		return atraccionesSinPrefenecias;
	}

	public ArrayList<Atraccion> getAtraccionesConPreferencias() {
		return atraccionesConPreferencias;
	}

	public ArrayList<Promocion> getPromocionesSinPreferencias() {
		return promocionesSinPreferencias;
	}

	public ArrayList<Promocion> getPromocionesConPreferencias() {
		return promocionesConPreferencias;
	}
	
	

}
