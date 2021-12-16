package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import model.Atraccion;
import model.Producto;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;
import model.nullobjects.NullAtr;
import model.nullobjects.NullUser;
import persistence.PromocionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class PromocionDAOImpl implements PromocionDAO {

	// Trae los datos de las promociones de al Base de Datos
	public ArrayList<Producto> findAll(HashMap<String, Producto> misAtracciones) {
		ArrayList<Producto> misPromos = new ArrayList<Producto>();

		try {
			String sql = "SELECT * FROM PROMOCION WHERE BORRADO = 0";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			while (resultados.next()) {
				String[] cadaAtr = resultados.getString(2).split("&");
				ArrayList<Atraccion> atrEnLaPromo = new ArrayList<Atraccion>();

				for (String s : cadaAtr) {

					Atraccion unAtr = (Atraccion) misAtracciones.get(s);
					if (unAtr == null) {
						unAtr = NullAtr.build();
					} else {
						atrEnLaPromo.add(unAtr); // mi array de atracciones que es un atributo de la clase
					} // Promocion
				}

				if (resultados.getString(5).equals("ABSOLUTA")) {
					Promocion promo = new PromocionAbsoluta(resultados.getInt(1), atrEnLaPromo, resultados.getString(3),
							TipoAtraccion.valueOf(resultados.getString(4)), resultados.getDouble(6));
					misPromos.add(promo);
				} else if (resultados.getString(5).equals("PORCENTUAL")) {
					Promocion promo = new PromocionPorcentual(resultados.getInt(1), atrEnLaPromo,
							resultados.getString(3), TipoAtraccion.valueOf(resultados.getString(4)),
							resultados.getDouble(6));
					misPromos.add(promo);
				} else {
					Promocion promo = new PromocionAxB(resultados.getInt(1), atrEnLaPromo, resultados.getString(3),
							TipoAtraccion.valueOf(resultados.getString(4)));

					misPromos.add(promo);
				}

			}

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		return misPromos;
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM PROMOCION";
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
	public int insert(Producto t) {
		try {
			String sql = "INSERT INTO PROMOCION (NOMBRE, INCLUYE, TIPO_ATRACCION, TIPO_PROMOCION, VALOR) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, t.getNombre());
			statement.setString(i++, ((Promocion) t).getNombresParaBaseDatos());
			statement.setString(i++, t.getTipo().toString()); // checkear que esto funcione realmente

			statement.setString(i++, ((Promocion) t).getTipoPromo().toString()); // hacer una para cada tipo?
			statement.setDouble(i++, ((Promocion) t).getValor());
			
		
			
			
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public int update(Producto t) {
		
		try {
			String sql = "UPDATE PROMOCION SET NOMBRE=?, INCLUYE=?, TIPO_ATRACCION=?, TIPO_PROMOCION=?, VALOR=? WHERE id_promocion = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, t.getNombre());
			statement.setString(i++, ((Promocion) t).getNombresParaBaseDatos());
			statement.setString(i++, t.getTipo().toString()); // checkear que esto funcione realmente

			statement.setString(i++, ((Promocion) t).getTipoPromo().toString()); // hacer una para cada tipo?

			statement.setDouble(i++, ((Promocion) t).getValor());
			statement.setDouble(i++, ((Promocion) t).getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}


	}

	@Override
	public int delete(Producto t) {
		try {
			String sql = "UPDATE PROMOCION SET BORRADO = 1 WHERE incluye LIKE ? ";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, "%" + t.getNombre() + "%");

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int deletePromo(Integer id) {
		try {
			String sql = "UPDATE PROMOCION SET BORRADO = 1 WHERE id = ? ";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public ArrayList<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto find(HashMap<String, Producto> misAtracciones, Integer id) {
		
		try {
			String sql = "SELECT * FROM PROMOCION WHERE id_promocion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Promocion promo = null;
			String[] cadaAtr = resultados.getString(2).split("&");
			ArrayList<Atraccion> atrEnLaPromo = new ArrayList<Atraccion>();

			for (String s : cadaAtr) {

				Atraccion unAtr = (Atraccion) misAtracciones.get(s);
				if (unAtr == null) {
					unAtr = NullAtr.build();
				} else {
					atrEnLaPromo.add(unAtr); // mi array de atracciones que es un atributo de la clase
				} // Promocion
			}

			if (resultados.getString(5).equals("ABSOLUTA")) {
				promo = new PromocionAbsoluta(resultados.getInt(1), atrEnLaPromo, resultados.getString(3),
						TipoAtraccion.valueOf(resultados.getString(4)), resultados.getDouble(6));
				
			} else if (resultados.getString(5).equals("PORCENTUAL")) {
				promo = new PromocionPorcentual(resultados.getInt(1), atrEnLaPromo,
						resultados.getString(3), TipoAtraccion.valueOf(resultados.getString(4)),
						resultados.getDouble(6));
				
			} else {
				promo = new PromocionAxB(resultados.getInt(1), atrEnLaPromo, resultados.getString(3),
						TipoAtraccion.valueOf(resultados.getString(4)));
			}


			return promo;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Producto find(Integer id) {
		
		return null;
	}

}
