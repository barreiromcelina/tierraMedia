package parque;

import productos.*;
import java.util.ArrayList;
import java.util.Collections;


import enums.TipoAtraccion;
import productos.*;

import manejoArchivos.*;
public class ParqueTierraMedia implements SistemaDeVenta,Escribir,Leer,Generar {

		public static void main(String[] args) {
			
			ArrayList<Usuario> usuarios = Generar.usuarios(Leer.a("usuarios.txt"));
			ArrayList<Atraccion> atracciones = Generar.atracciones(Leer.a("atracciones.txt"));
			ArrayList<Promocion> promociones = Generar.promociones(Leer.a("promos.txt"),atracciones);
			
//			String[] 
//				personas = new String[] {
//					"nombre:Orlando, preferencia:AVENTURA, presupuesto:20, horas:6.0d",
//					"nombre:Yanina, preferencia:DEGUSTACION, presupuesto:10, horas:4.0d",
//					"nombre:Nea, preferencia:PAISAJE, presupuesto:30, horas:8.0d",
//				},
//				atrac = new String[] {
//					"nombre:MarioBut'sReal, tipo:AVENTURA, precio:5, cupos:1, horas:4.0d",
//					"nombre:Carreras, tipo:AVENTURA, precio:7, cupos:7, horas:1.0d",
//					"nombre:SaltoDelPuente, tipo:AVENTURA, precio:2, cupos:5, horas:0.5d",
//					"nombre:CocinaMedieval, tipo:DEGUSTACION, precio:2, cupos:30, horas:1.5d",
//					"nombre:MCDonals, tipo:DEGUSTACION, precio:10, cupos:150, horas:2.0d",
//					"nombre:SelvaYComida, tipo:DEGUSTACION, precio:4, cupos:20, horas:1.0d",
//					"nombre:Crateras, tipo:PAISAJE, precio:3, cupos:20, horas:1.0d",
//					"nombre:GranCanon, tipo:PAISAJE, precio:4, cupos:15, horas:0.75d",
//					"nombre:Cascada, tipo:PAISAJE, precio:4, cupos:30, horas:0.5d"
//				},
//				promo = new String[] {
//					"nombre:AltoRiesgo, tipo:AVENTURA, incluye:MarioBut'sReal,Carreras,SaltoDelPuente, precio:10",
//					"nombre:SaboresYColores, tipo:DEGUSTACION, incluye:CocinaMedieval,MCDonals, gratis:SelvaYComida",
//					"nombre:FondosDePantallasBut'sReal, tipo:PAISAJE, incluye:Crateras,GranCanon,Cascada, descuento:20"
//				};
			
			
			
//			ArrayList<Usuario> usuarios = Generar.usuarios(Cadena.seleccion(personas).union("\n"));
//			ArrayList<Atraccion> atracciones = Generar.atracciones(Cadena.seleccion(atrac).union("\n"));
//			ArrayList<Promocion> promociones = Generar.promociones(Cadena.seleccion(promo).union("\n"), atracciones);
			
			ArrayList<Producto> aOfrecer = new ArrayList<Producto>();
			aOfrecer.addAll(promociones);
			aOfrecer.addAll(atracciones);
			
			for(Usuario usuarioActual:usuarios) {
				Collections.sort(aOfrecer, new ComparadorDeConveniencia(usuarioActual.getPreferencia()));
				SistemaDeVenta.venderProductosA(usuarioActual, aOfrecer);
				Escribir.elItinerarioDe(usuarioActual); 
			}
				
		}
		
	}
