package dao;

import parque.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public abstract Usuario findByNombre (String nombre);
}
