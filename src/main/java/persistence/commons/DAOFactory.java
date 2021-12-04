package persistence.commons;

import persistence.impl.AtraccionDAOImpl;
import persistence.impl.ItinerarioDAOImpl;
import persistence.impl.PromocionDAOImpl;
import persistence.impl.UsuarioDAOImpl;
import persistences.AtraccionDAO;
import persistences.ItinerarioDAO;
import persistences.PromocionDAO;
import persistences.UsuarioDAO;

public class DAOFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static AtraccionDAO getAtraccionDAO( ) {
		return new AtraccionDAOImpl();
	}
	public static PromocionDAO getPromocionDAO( ) {
		return new PromocionDAOImpl();
	}
	public static ItinerarioDAO getItinerarioDAO() {
		return new ItinerarioDAOImpl();
	}
}
