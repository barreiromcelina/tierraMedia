package manejoArchivos;

import java.util.ArrayList;
import java.util.Collections;

import parque.*;
import enums.TipoAtraccion;
import productos.*;

public interface Generar {


	public static Usuario usuario(String cadena) {
		Usuario nuevoUsuario = new Usuario();
		String[] cadenaArreglo = cadena.split(", ");
		for (String par : cadenaArreglo) {
			String[] clave0YValor1 = par.split(":");
			String clave = clave0YValor1[0];
			String valor = clave0YValor1[1];
			switch (clave) {
			case "nombre":
				nuevoUsuario.setNombre(valor);
				break;
			case "preferencia":
				TipoAtraccion valorTipo = TipoAtraccion.valueOf(valor);
				nuevoUsuario.setPreferencia(valorTipo);
				break;
			case "presupuesto":
				int valorInteger = Integer.parseInt(valor);
				nuevoUsuario.setPresupuesto(valorInteger);
				break;
			case "tiempo":
				double valorDouble = Double.parseDouble(valor);
				nuevoUsuario.setHoras(valorDouble);
				break;
			default:
				throw new IllegalArgumentException("clave desconocida! "+  clave );
			}

		}
		return nuevoUsuario;
	}

	public static ArrayList<Usuario> usuarios(String datosDeLasPersonas) {
		String[] datosDeCadaPersona = datosDeLasPersonas.split("\n");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		for (int i = 0; i < datosDeCadaPersona.length; i++)
			usuarios.add(usuario(datosDeCadaPersona[i]));
		return usuarios;
	}

	public static Atraccion atraccion(String cadena) {
		Atraccion nuevaAtraccion = new Atraccion();
		String[] cadenaArreglo = cadena.split(", ");
		for (String par : cadenaArreglo) {
			String[] clave0YValor1 = par.split(":");
			String clave = clave0YValor1[0];
			String valor = clave0YValor1[1];
			switch (clave) {
			case "nombre":
				nuevaAtraccion.setNombre(valor);
				break;
			case "tipo":
				TipoAtraccion valorTipo = TipoAtraccion.valueOf(valor);
				nuevaAtraccion.setTipo(valorTipo);
				break;
			case "costo":
				int valorInteger = Integer.parseInt(valor);
				nuevaAtraccion.setPrecio(valorInteger);
				break;
			case "cupos":
				int valorIntegerTwo = Integer.parseInt(valor);
				nuevaAtraccion.setCupos(valorIntegerTwo);
				break;
			case "horas":
				double valorDouble = Double.parseDouble(valor);
				nuevaAtraccion.setHoras(valorDouble);
				break;
			default:
				throw new IllegalArgumentException("clave desconocida! " + clave);
			}
		}
		return nuevaAtraccion;
	}

	public static ArrayList<Atraccion> atracciones(String construct) {
		String[] constructores = construct.split("\n");
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		for (int i = 0; i < constructores.length; i++)
			atracciones.add(atraccion(constructores[i]));
		return atracciones;
	}

	private static void setDes(Promocion p, int d) {
		((PromocionPorcentual)p).setDescuento(d);
	}
	
	public static Promocion promocion(String datosDeLaPromocion, ArrayList<Atraccion> parque) {
		String[] config = datosDeLaPromocion.split(", ");

		// #definicion
		Promocion nuevaPromocion = new PromocionAbsoluta();
		boolean per = false;
		boolean axb = false;
		for (String claveValor : config) {
			String clave = claveValor.split(":")[0];
			switch (clave) {
			case "precio":
				break;
			case "descuento":
				per = true;
				break;
			case "gratis":
				axb = true;
				break;
			}
		}
		if (axb)
			nuevaPromocion = new PromocionAxB();
		if (per)
			nuevaPromocion = new PromocionPorcentual();
		int descuento = 0;

		for (String claveValor : config) {
			String[] clave0YValor1 = claveValor.split(":");
			String clave = clave0YValor1[0];
			String valor = clave0YValor1[1];
			switch (clave) {
			case "nombre":
				nuevaPromocion.setNombre(valor);
				break;
			case "tipo":
				TipoAtraccion tipo = TipoAtraccion.valueOf(valor);
				nuevaPromocion.setTipo(tipo);
				break;
			case "costo":
				int precio = Integer.parseInt(valor);
				nuevaPromocion.setPrecio(precio);
				break;
			case "cupos":
				int cupos = Integer.parseInt(valor);
				nuevaPromocion.setCupos(cupos);
				break;
			case "tiempo":
				double horas = Double.parseDouble(valor);
				nuevaPromocion.setHoras(horas);
				break;
			case "incluye":
				String[] nombres = valor.split(",");

				nuevaPromocion.setContenido(new Atraccion[(axb) ? nombres.length + 1 : nombres.length]);
				nuevaPromocion.setCupos(100000000);
				
				for (int pos = 0; pos < nombres.length; pos++) {
					for (Atraccion i : parque) {
						if (i.getNombre().equals(nombres[pos])) {
							if(per || axb) nuevaPromocion.setPrecio(nuevaPromocion.getPrecio() + i.getPrecio());
							nuevaPromocion.setHoras(nuevaPromocion.getHoras() + i.getHoras());
							nuevaPromocion.setCupos((i.getCupos() < nuevaPromocion.getCupos()) ? i.getCupos()
									: nuevaPromocion.getCupos());
							nuevaPromocion.getContenido()[pos] = i;
						}
					}
				}
				// if(!per && !axb)
				break;
			case "descuento":
				int valorDescuento = Integer.parseInt(valor);
				descuento = valorDescuento;
				if (per)
					setDes(nuevaPromocion, descuento);
				break;
			case "gratis":
				for (Atraccion i : parque) {
					if (i.getNombre().equals(valor)) {
						nuevaPromocion.setHoras(nuevaPromocion.getHoras() + i.getHoras());
						nuevaPromocion.setCupos(
								(i.getCupos() < nuevaPromocion.getCupos()) ? i.getCupos() : nuevaPromocion.getCupos());
						nuevaPromocion.getContenido()[nuevaPromocion.getContenido().length - 1] = i;
						if (axb)
							((PromocionAxB) nuevaPromocion).setGratis(i);
					}
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + clave);
			}
		}
		if (per)
			nuevaPromocion.setPrecio((int) (nuevaPromocion.getPrecio() * (100 - ((PromocionPorcentual) nuevaPromocion).getDescuento()) / 100));
		return nuevaPromocion;
	}

	public static ArrayList<Promocion> promociones(String configuracion, ArrayList<Atraccion> parque) {
		String[] constructores = configuracion.split("\n");
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();
		for (int iterador = 0; iterador < constructores.length; iterador++)
			promociones.add(promocion(constructores[iterador], parque));
		return promociones;
	}

}