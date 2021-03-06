package persistence;

import model.Usuario;
import persistence.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public abstract Usuario findByNombre (String nombre);

	public abstract int edit(Usuario usuarioEditado);
}
