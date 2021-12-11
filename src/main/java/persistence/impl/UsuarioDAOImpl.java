package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TipoAtraccion;
import model.Usuario;
import model.nullobjects.NullUser;
import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UsuarioDAOImpl implements UsuarioDAO {

	//Trae los datos de los Usuarios desde la Base de Datos
	public ArrayList<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM Usuarios";
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
		// ----id----admin----nombre----password----presupuesto----tiempo----Preferencia---------------
		
		return new Usuario(resultados.getInt(1), resultados.getBoolean(2), resultados.getString(3), resultados.getString(4), 
				resultados.getDouble(5), resultados.getDouble(6), TipoAtraccion.valueOf(resultados.getString(7)));
		 
	}

	//Retorna el total de registros en la BD
	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM USUARIOS";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Usuario usuarioNuevo) {
		try {
			String sql = "INSERT INTO USUARIOS (NOMBRE, PASSWORD, PRESUPUESTO, TIEMPO, TIPO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, usuarioNuevo.getNombre());
			statement.setString(2, usuarioNuevo.getPassword());
			statement.setDouble(3, usuarioNuevo.getPresupuesto());
			statement.setDouble(4, usuarioNuevo.getTiempoDisponible());
			statement.setString(5, usuarioNuevo.getTipoAtraccionPreferida().toString());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
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
		try {
			String sql = "UPDATE USUARIOS SET BORRADO = 1 WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, t.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario findByNombre(String nombre) {
		try {
			String sql = "SELECT * FROM USUARIOS WHERE NOMBRE = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Usuario find(Integer id) {
		try {
			String sql = "SELECT * FROM Usuarios WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario usuario = NullUser.build();

			if (resultados.next()) {
				usuario = toUsuario(resultados);
			}

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
