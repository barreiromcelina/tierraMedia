package persistence;

import java.util.ArrayList;

import model.Producto;
import model.Usuario;
import persistence.commons.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Usuario> {
	
	public String findItinerario(Usuario u);
	public Integer findCosto(Usuario u);
	public Integer findTiempo(Usuario u);
	public Integer findUser(Usuario u);
	public ArrayList<Producto> findItinerarioObjetcs(Integer userId);
	public Integer insertItinerarioAtraccion(int userId, Integer atrId);

	

}
