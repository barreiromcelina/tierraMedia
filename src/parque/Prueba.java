//package parque;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//import dao.AtraccionDAO;
//import dao.DAOFactory;
//import dao.PromocionDAOImpl;
//import dao.UsuarioDAO;
//import manejoArchivos.Lector;
//import productos.Producto;
//
//public class Prueba {
// 
//	
//	public static void main (String args[]) {
//		 
//				
//		ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
//		UsuarioDAO UsuarioDAO = DAOFactory.getUsuarioDAO();
//		misUsuarios = UsuarioDAO.findAll();
//		System.out.println(misUsuarios);
//		
//		ArrayList<Producto> misAtracciones = new ArrayList<Producto>();
//		AtraccionDAO AtraccionDAO = DAOFactory.getAtraccionDAO();
//		misAtracciones = AtraccionDAO.findAll();
//		System.out.println(misAtracciones);
//		
//		
//		Map<String, Producto> misAtracc = Lector.crearMapaAtraccion();
//		
//		
//		ArrayList<Producto> misPromos = new ArrayList<Producto>();
//		misPromos = PromocionDAOImpl.findAll((HashMap<String, Producto>) misAtracc);
//		System.out.println(misPromos);
//		
//		
//		ParqueTierraMedia parqueAtracciones = new ParqueTierraMedia(misUsuarios, misPromos, misAtracciones);
//		parqueAtracciones.ofrecerProducto(misUsuarios);
//		
//		
//		
//	}
//}
