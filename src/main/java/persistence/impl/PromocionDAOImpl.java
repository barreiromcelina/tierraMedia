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
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;
import persistences.PromocionDAO;

public class PromocionDAOImpl implements PromocionDAO{
	
	//Trae los datos de las promociones de al Base de Datos
	public ArrayList<Producto> findAll(HashMap<String, Producto> misAtracciones) {
		ArrayList<Producto> misPromos = new ArrayList<Producto>();
		
		try {
			String sql = "SELECT * FROM PROMOCION";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			
			while (resultados.next()){
				String[] cadaAtr = resultados.getString(2).split("&");
				ArrayList<Atraccion> atrEnLaPromo = new ArrayList<Atraccion>();

				for (String s : cadaAtr) {
					atrEnLaPromo.add((Atraccion) misAtracciones.get(s)); // mi array de atracciones que es un atributo de la clase
																// Promocion
				}

				if (resultados.getString(5).equals("ABSOLUTA")) {
					Promocion promo = new PromocionAbsoluta(atrEnLaPromo, resultados.getString(3), TipoAtraccion.valueOf(resultados.getString(4)),
							resultados.getDouble(6));
					misPromos.add(promo);
				} else if (resultados.getString(5).equals("PORCENTUAL")) {
					Promocion promo = new PromocionPorcentual(atrEnLaPromo, resultados.getString(3), TipoAtraccion.valueOf(resultados.getString(4)),
							resultados.getDouble(6));
					misPromos.add(promo);
				} else {
					Promocion promo = new PromocionAxB(atrEnLaPromo, resultados.getString(3), TipoAtraccion.valueOf(resultados.getString(4)));
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Producto t) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public int update(Producto t) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public int delete(Producto t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
