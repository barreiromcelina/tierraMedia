package manejoArchivos;


import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Cadena {

	public static void main(String[] args) {
		String a = Cadena.seleccion(new String[] {"aaa", "aaaa"}).reduccion(((unico, elem) -> unico.length() < elem.length()? elem : unico));
		System.out.println(a);
	}

	// #propiedades
	public String valor;

	//#subClases
	public class Posicion {

		public String valor;
		public String bandera;

		public Posicion(String cadena, String bandera) {
			this.valor = cadena;
			this.bandera = bandera;
		}

		public String en(int tamano) {
			String espacios = "";
			String valor = "";
			if (!this.bandera.equals("medio"))
				for (int i = this.valor.length(); i < tamano; i++)
					espacios += " ";
			switch (this.bandera) {
				case "inicio":
					valor = espacios + this.valor;
					break;
				case "final":
					valor = this.valor + espacios;
					break;			
				case "medio":
					for (int i = 0; i < (tamano - this.valor.length()) / 2; i++)
						espacios += " ";
					valor = espacios + this.valor + (((valor.length() % 2 == 0) != (tamano % 2 == 0))? " " : "") + espacios;
					break;
			}
			return valor;
		}
		
		public String en(String segun) {
			return (this.bandera.equals("inicio"))? this.en(segun.length()) 
					:(this.bandera.equals("final"))? this.en(segun.length())
					: this.en(segun.length());
		}
		
		public String limpiar() {
			
			return "";
		}

	}
	
	public static class ArregloDeCadenas {
		
		public String[] valores;
		
		public ArregloDeCadenas() {
			
		}
		public ArregloDeCadenas(String[] valores) {
			this.valores = valores;
		}
		
		public String reduccion(BiFunction<String, String, String> callback) {
			String resultado = this.valores[0];	
			for(int i = 1; i < this.valores.length; i++) 
				resultado = callback.apply(resultado, this.valores[i]);
			return resultado;
		}		
		
		public String[] mapear(Function<String, Object> callback) {
			String[] nuevoArreglo = new String[this.valores.length];
			for(int i = 0; i < nuevoArreglo.length; i++)
				nuevoArreglo[i] = String.valueOf(callback.apply(this.valores[i]));
			return nuevoArreglo;
		}
		
		public String union(String intermedio) {
			String valor = this.valores[0];
			for(int i = 1; i < this.valores.length; i++)
				valor += intermedio + this.valores[i];
			return valor;
		}
		
	} 
	
	// #constructores
	public Cadena() {

	}
	public Cadena(String valor) {
		this.valor = valor;
	}

	// #metodos
	public Posicion posicion(String bandera) {
		return new Posicion(this.valor, bandera);
	}	
	//public Eliminar
	
	// #estatico

	public static ArregloDeCadenas seleccion(String[] arreglo) {
		ArregloDeCadenas nuevo = new ArregloDeCadenas(arreglo);
		return nuevo;
	}
	
	public static Cadena seleccion(String cadena) {
		return new Cadena(cadena);
	}

	public static String[] mapear(Object[] arreglo, Function<Object,String> callback) {
		String[] nuevoArreglo = new String[arreglo.length];
		for(int i = 0; i < nuevoArreglo.length; i++)
			nuevoArreglo[i] = callback.apply(arreglo[i]);
		return nuevoArreglo;
	}


}
