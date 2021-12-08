package services;

import java.util.List;

import model.Producto;
import persistence.commons.DAOFactory;

public class promoService {

	public List<Producto> obtenerAllPromos() {
		return DAOFactory.getPromocionDAO().findAll();
	}
	
	

}
