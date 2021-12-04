package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import enums.TipoAtraccion;
import parque.OrdenarSegunPreferencia;
import productos.Atraccion;
import productos.Producto;
import productos.PromocionPorcentual;

public class ListaProductosTest {
	Atraccion atraccion1 = new Atraccion("Moria", 10, TipoAtraccion.AVENTURA, 6, 2);
	Atraccion atraccion2 = new Atraccion("Mordor", 25, TipoAtraccion.AVENTURA, 4, 3);
	Atraccion atraccion3 = new Atraccion("Monta", 15, TipoAtraccion.AVENTURA, 5, 3);
	Atraccion atraccion4 = new Atraccion("Minas Tirith", 5, TipoAtraccion.PAISAJE, 25, 2.5);
	Atraccion atraccion5 = new Atraccion("Abismos de Helm", 5, TipoAtraccion.PAISAJE, 15, 2);
	
	ArrayList<Atraccion> arrayAventura= new ArrayList<Atraccion>();
	ArrayList<Atraccion> arrayPaisaje= new ArrayList<Atraccion>();
	
	
	

	@Test
	public void OrdenarListaProductosPreferenciaAventuraTest() {
		arrayAventura.add(atraccion1);
		arrayAventura.add(atraccion2);
		arrayPaisaje.add(atraccion4);
		arrayPaisaje.add(atraccion5);
		
		Producto promoAventura = new PromocionPorcentual(arrayAventura, "Pack Aventura", TipoAtraccion.AVENTURA, 0.2);
		Producto promoPaisaje = new PromocionPorcentual(arrayPaisaje, "Pack Paisaje", TipoAtraccion.PAISAJE, 0.1);
		
		ArrayList<Producto> misProductos= new ArrayList<Producto>();
		
		misProductos.add(promoAventura);
		misProductos.add(promoPaisaje);
		misProductos.add(atraccion1);
		misProductos.add(atraccion2);
		misProductos.add(atraccion3);
		misProductos.add(atraccion4);
		misProductos.add(atraccion5);
		
		Collections.sort(misProductos, new OrdenarSegunPreferencia(TipoAtraccion.AVENTURA));
		
		assertEquals(5, misProductos.get(0).getTiempoPromedio(), 0.01);
		assertEquals(25, misProductos.get(1).getCosto(), 0.01);
		assertEquals(15, misProductos.get(2).getCosto(), 0.01);
		assertEquals(10, misProductos.get(3).getCosto(), 0.01);
		assertEquals(4.5, misProductos.get(4).getTiempoPromedio(), 0.01);
		
	}
	
	@Test
	public void OrdenarListaProductosPreferenciaPaisajeTest() {
		arrayAventura.add(atraccion1);
		arrayAventura.add(atraccion2);
		arrayPaisaje.add(atraccion4);
		arrayPaisaje.add(atraccion5);
		
		Producto promoAventura = new PromocionPorcentual(arrayAventura, "Pack Aventura", TipoAtraccion.AVENTURA, 0.2);
		Producto promoPaisaje = new PromocionPorcentual(arrayPaisaje, "Pack Paisaje", TipoAtraccion.PAISAJE, 0.1);
		
		ArrayList<Producto> misProductos= new ArrayList<Producto>();
		
		misProductos.add(promoAventura);
		misProductos.add(promoPaisaje);
		misProductos.add(atraccion1);
		misProductos.add(atraccion2);
		misProductos.add(atraccion3);
		misProductos.add(atraccion4);
		misProductos.add(atraccion5);
		
		Collections.sort(misProductos, new OrdenarSegunPreferencia(TipoAtraccion.PAISAJE));
		
		assertEquals(4.5, misProductos.get(0).getTiempoPromedio(), 0.01);
		assertEquals(2.5, misProductos.get(1).getTiempoPromedio(), 0.01);
		assertEquals(2, misProductos.get(2).getTiempoPromedio(), 0.01);
		assertEquals(5, misProductos.get(3).getTiempoPromedio(), 0.01);
		
	}
	
	

}
