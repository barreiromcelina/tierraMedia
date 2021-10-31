package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enums.TipoAtraccion;
import jdbc.ConnectionProvider;
import parque.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	public ArrayList<Usuario> findAll(){
		try {
			String sql = "SELECT * FROM USUARIOS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			ArrayList<Usuario> misUsuarios = new ArrayList<Usuario>();
			while (resultados.next()) {
				misUsuarios.add(toUsuario(resultados));
			}

			return misUsuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private static Usuario toUsuario(ResultSet resultados) throws SQLException {
		//-------------------------nombre-------------------presupuesto---------------tiempo---------------Preferencia---------------
		return new Usuario(resultados.getString(2),resultados.getDouble(3), resultados.getDouble(4), TipoAtraccion.valueOf(resultados.getString(5)));
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(Usuario t) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void update(Usuario u) throws SQLException {
		String sql = "UPDATE Usuarios SET presupuesto=?, tiempo=? WHERE nombre=?;";  //el presupuesto en la BD debería ser REAL??
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setDouble(1, u.getPresupuesto());
		statement.setDouble(2, u.getTiempoDisponible());
		statement.setString(3, u.getNombre());
		statement.executeUpdate();
		
		
	}

	@Override
	public int delete(Usuario t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}
