package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import enums.TipoAtraccion;
import manejoArchivos.Lector;
import productos.Atraccion;
import productos.Promocion;
import productos.Producto;


public class CrearPromoTest {
	
	Atraccion atraccion1 = new Atraccion("Moria", 10, TipoAtraccion.AVENTURA, 6, 2);
	Atraccion atraccion2 = new Atraccion("Mordor", 25, TipoAtraccion.AVENTURA, 4, 3);
	Atraccion atraccion3= new Atraccion("Monta", 15, TipoAtraccion.AVENTURA, 5, 3);
	Atraccion atraccion4= new Atraccion("Minas Tirith", 5, TipoAtraccion.AVENTURA, 25, 2.5);
	Atraccion atraccion5= new Atraccion("Abismos de Helm", 5, TipoAtraccion.AVENTURA, 15, 2);
	
	
	HashMap<String,Producto> misAtrEnPromo = new HashMap<String,Producto>();
	
	String directorio = "C:\\Users\\celib\\eclipse-workspace\\TierraMedia\\archivos\\";
	

	@Test
	public void crearPromosTest() {
		misAtrEnPromo.put("Moria", atraccion1);
		misAtrEnPromo.put("Mordor", atraccion2);
		misAtrEnPromo.put("Monta", atraccion3);
		misAtrEnPromo.put("Minas Tirith", atraccion4);
		misAtrEnPromo.put("Abismos de Helm", atraccion5);
		
		
		ArrayList<Producto> miPromo = Lector.crearPromos(directorio+"promos.csv", misAtrEnPromo);
		Double precioObtenido= miPromo.get(0).getCosto();
		assertEquals(12, precioObtenido, 0.01);
		Double tiempoPromObtenido = miPromo.get(0).getTiempoPromedio();
		assertEquals(5, tiempoPromObtenido,0.01);
		Double precioObtenido2= miPromo.get(1).getCosto();
		assertEquals(8, precioObtenido2, 0.01);
		Double tiempoPromObtenido2 = miPromo.get(1).getTiempoPromedio();
		assertEquals(4.5, tiempoPromObtenido2,0.01);
			
	}

}










