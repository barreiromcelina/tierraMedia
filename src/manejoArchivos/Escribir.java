package manejoArchivos;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import productos.*;
import parque.*;

public interface Escribir {

	public static String DIR = "C:\\Users\\User\\3D Objects\\Programacion\\Eclipse\\#YoProgramo\\java\\tp-turismo-en-tierra-media\\tierraMedia\\archivos\\";
	
	public static void en(String nombreDeArchivo, String aEscribir) {
		try {
			String[] lineasAEscribir = aEscribir.split("\n");
			BufferedWriter escritor = new BufferedWriter(new FileWriter(DIR + nombreDeArchivo));
			
			escritor.write(aEscribir);

			escritor.close();
		} catch(IOException e) {
			System.err.println(e);
		}
	}
	
	public static void algoMasEn(String nombreDeArchivo, String aEscribir) {
		Escribir.en(nombreDeArchivo, Leer.a(nombreDeArchivo) + aEscribir);
	}
	
	public static void elItinerarioDe(Usuario usuario) {
		Escribir.en(usuario.getNombre() + ".txt", usuario.getNombre() + " [");
		for(Producto atraccionEnItinerario:usuario.getItinerario())
			Escribir.algoMasEn(usuario.getNombre() + ".txt", "\t" + atraccionEnItinerario.getNombre());
		Escribir.algoMasEn(usuario.getNombre() + ".txt", "]");
	}
	
}

