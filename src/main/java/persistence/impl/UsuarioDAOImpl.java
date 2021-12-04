package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TipoAtraccion;
import model.Usuario;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import persistences.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO {

	//Trae los datos de los Usuarios desde la Base de Datos
	public ArrayList<Usuario> findAll() {
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

	//convierte el ResultSet en Usuario
	private static Usuario toUsuario(ResultSet resultados) throws SQLException {
		// -------------------------nombre-------------------presupuesto---------------tiempo---------------Preferencia---------------
		return new Usuario(resultados.getString(2), resultados.getDouble(3), resultados.getDouble(4),
				TipoAtraccion.valueOf(resultados.getString(5)));
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Usuario t) {
		return 0;
		// TODO Auto-generated method stub

	}

	//Actualiza los presupuestos y tiempo disponible de los usuarios luego de hacer las compras
	@Override
	public int update(Usuario u) {
		try {
			String sql = "UPDATE Usuarios SET presupuesto=?, tiempo=? WHERE nombre=?;"; 
																						
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, u.getPresupuesto());
			statement.setDouble(2, u.getTiempoDisponible());
			statement.setString(3, u.getNombre());
			int rows = statement.executeUpdate();
			
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		

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
