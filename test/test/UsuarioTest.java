package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enums.TipoAtraccion;
import parque.Usuario;
import productos.Atraccion;
import productos.Promocion;
import productos.PromocionAxB;
import productos.PromocionPorcentual;

public class UsuarioTest {
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void SugerirOpcionestest() {
		//Creando Usuario
		Usuario usuario = new Usuario("Juanito",99,99,TipoAtraccion.PAISAJE);

		
		//Carga Lista de Atracciones
		ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>(); 
		listaAtracciones.add(new Atraccion("Erebor", 12, TipoAtraccion.PAISAJE, 3, 32));//caso:tipoAtraccion==tipoUsuario
		listaAtracciones.add(new Atraccion("La Comarca", 3, TipoAtraccion.DEGUSTACION, (int) 6.5, 32));//caso:tipoAtraccion<>tipoUsuario
		
		
		//carga Lista de Promociones
		ArrayList<Promocion> listaPromociones = new ArrayList<Promocion>();
		
		ArrayList<Atraccion> paqueteAventura=new ArrayList<Atraccion>();
		paqueteAventura.add(new Atraccion("Moria", 10, TipoAtraccion.AVENTURA, 6, 2));
		paqueteAventura.add( new Atraccion("Mordor", 25, TipoAtraccion.AVENTURA, 4, 3));
		paqueteAventura.add(new Atraccion("Monta", 15, TipoAtraccion.AVENTURA, 5, 3));
		
		PromocionPorcentual promoPorcentual = 
				new PromocionPorcentual(paqueteAventura, "Pack Aventura",TipoAtraccion.AVENTURA, 0.2);
		
		listaPromociones.add(promoPorcentual);// caso: tipoUsuario<>promocion.Tipo
		
		
		ArrayList<Atraccion> paquetePaisaje = new ArrayList<Atraccion>();
		paquetePaisaje.add(new Atraccion("Minas Tirith", 10, TipoAtraccion.PAISAJE, (int) 2.5, 25));
		paquetePaisaje.add( new Atraccion("Abismo de Helm",5, TipoAtraccion.PAISAJE, 2, 15));
		paquetePaisaje.add(new Atraccion("Erebor", 12, TipoAtraccion.PAISAJE, 3, 32));
		
		PromocionAxB promoAxB= new PromocionAxB(paquetePaisaje, "Pack Paisaje 3x2" , TipoAtraccion.PAISAJE);
			
		listaPromociones.add(promoAxB);// caso: tipoUsuario==promocion.Tipo
				
		//Llamo metodo y verifico Un ejemplo de c/u
		usuario.sugerirOpciones(listaAtracciones, listaPromociones);
	
		Assert.assertEquals(1,usuario.getAtraccionesConPreferencias().size());//tipoUsuario==tipoAtraccion
		
		Assert.assertEquals(1,usuario.getAtraccionesSinPrefenecias().size());//tipoUsuario<>tipoAtraccion
		
		Assert.assertEquals(1,usuario.getPromocionesSinPreferencias().size());//tipoUsuario<>tipoPromocion
		
		Assert.assertEquals(1,usuario.getPromocionesConPreferencias().size());//tipoUsuario==tipoPromocion
	}
	

}
