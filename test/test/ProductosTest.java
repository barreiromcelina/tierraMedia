package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import enums.TipoAtraccion;
import productos.Atraccion;
import productos.Producto;
import productos.PromocionAbsoluta;
import productos.PromocionAxB;
import productos.PromocionPorcentual;

public class ProductosTest {

	Atraccion atraccion1 = new Atraccion("Moria", 10, TipoAtraccion.AVENTURA, 6, 2);
	Atraccion atraccion2 = new Atraccion("Mordor", 25, TipoAtraccion.AVENTURA, 4, 3);
	Atraccion atraccion3= new Atraccion("Monta", 15, TipoAtraccion.AVENTURA, 5, 3);

	@Test
	public void getCostoPromoPorcentual() {
		ArrayList<Atraccion> paqueteAventura = new ArrayList<Atraccion>();
		paqueteAventura.add(atraccion1);
		paqueteAventura.add(atraccion2);
		PromocionPorcentual promoPorcentual = new PromocionPorcentual(paqueteAventura, "Pack Aventura",
				TipoAtraccion.AVENTURA, 0.2);
		assertEquals(35 * 0.8, promoPorcentual.precioPromocional(), 0.01);
	}
	
	@Test
	public void getCostroPromoAxB() {
		ArrayList<Atraccion> paqueteAventura = new ArrayList<Atraccion>();
		paqueteAventura.add(atraccion1);
		paqueteAventura.add(atraccion2);
		paqueteAventura.add(atraccion3);
		PromocionAxB promoAxB= new PromocionAxB(paqueteAventura, "Pack Aventura 3x2" , TipoAtraccion.AVENTURA);
		assertEquals(35, promoAxB.precioPromocional(),0.01);
	}
	
	@Test
	public void getCostroPromoAbs() {
		ArrayList<Atraccion> paqueteAventuraAbs = new ArrayList<Atraccion>();
		paqueteAventuraAbs.add(atraccion1);
		paqueteAventuraAbs.add(atraccion2);
		paqueteAventuraAbs.add(atraccion3);
		PromocionAbsoluta promoAxB= new PromocionAbsoluta(paqueteAventuraAbs, "Pack Aventura a precio fijo" , TipoAtraccion.AVENTURA, 40);
		assertEquals(40, promoAxB.precioPromocional(),0.01);
	}
	
	@Test
	public void getTiempoPromedioPromoAxB() {
		ArrayList<Atraccion> paqueteAventura = new ArrayList<Atraccion>();
		paqueteAventura.add(atraccion1);
		paqueteAventura.add(atraccion2);
		paqueteAventura.add(atraccion3);
		PromocionAxB promoAxB= new PromocionAxB(paqueteAventura, "Pack Aventura 3x2" , TipoAtraccion.AVENTURA);
		assertEquals(8, promoAxB.getTiempoPromedio(),0.01);
	}
	
	
	
	
	

}
