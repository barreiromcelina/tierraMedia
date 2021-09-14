package manejoArchivos;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;

import parque.Usuario;
import productos.Producto;

public class Escritor {
	
Usuario usuario;
	
	
	
	public Escritor(Usuario usuario) {
		super();
		this.usuario = usuario;
	}



	public static void imprimirArchivo(Usuario usuario) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		String nombreArchivo = usuario.getNombre()+" Ininerario.out"; //esta linea me da error porque los getters del Usuario estan en protected
		
		//------------------Necesito recibir el itinerario desde Usuario
		ArrayList<Producto> itinerario = new ArrayList<Producto>();
		itinerario = usuario.getItinerario();	//Aqui es donde me llega el itinerario del usuario
		//------------------
		
		try {
			fichero = new FileWriter(nombreArchivo);
			pw = new PrintWriter(fichero);
			
			pw.println("Usuario "+ usuario.getNombre()+":\n"+ usuario.getItinerario()+"\n"+ "Costo total: " + (usuario.PRESUPUESTO_INICIAL -usuario.getPresupuesto())+
					"\n" + "Tiempo de visita: " + (usuario.TIEMPO_INICIAL- usuario.getTiempoDisponible())); //aqui usaria el itinerario del usuario
		} catch (Exception e) {
			e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		
		
	}
	
	

}
