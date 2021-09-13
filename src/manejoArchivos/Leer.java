package manejoArchivos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface Leer {
	
	public static String DIR = "C:\\Users\\User\\3D Objects\\Programacion\\Eclipse\\#YoProgramo\\java\\tp-turismo-en-tierra-media\\tierraMedia\\archivos\\";
	
	public static String a(String nombreDeArchivo) { 
		String valor = "";
		try {
			String linea = "";
			BufferedReader lector = new BufferedReader(new FileReader(DIR + nombreDeArchivo));
			
			while((linea = lector.readLine()) != null)
				valor += linea + ";";
			
			lector.close();
		} catch(IOException e) {
			System.err.print(e);
		}
		return valor.replaceAll(";", "\n");	
	}
	
}