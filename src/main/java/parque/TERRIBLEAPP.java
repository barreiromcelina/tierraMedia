package parque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import model.Atraccion;
import model.OrdenarSegunPreferencia;
import model.Producto;
import model.Promocion;
import model.PromocionAbsoluta;
import model.PromocionAxB;
import model.PromocionPorcentual;
import model.TipoAtraccion;
import model.nullobjects.NullAtr;
import persistence.ItinerarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import services.atraccionService;
import services.itinerarioService;
import services.promoService;

public class TERRIBLEAPP {

	public static void main(String[] args) throws SQLException {

		atraccionService aService = new atraccionService();
		promoService pService= new promoService();
		
		HashMap<String, Producto> misAtracciones = (HashMap<String, Producto>) pService.crearMapaAtraccion();
		
		String sql = "SELECT Promocion.id_promocion, Promocion.incluye, Promocion.nombre, Promocion.[tipo atraccion], Promocion.[tipo de promocion], Promocion.valor "
				+ "FROM Itinerarios "
				+ "JOIN Itinerarios_Promocion ON Itinerarios_Promocion.id_itinerario = Itinerarios.id_itinerario "
				+ "JOIN Promocion ON Promocion.id_promocion = Itinerarios_Promocion.id_promocion "
				+ "WHERE Itinerarios.id_usuario = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, 9);

		ResultSet resultados = statement.executeQuery();
		ArrayList<Producto> misPromos = new ArrayList<Producto>();

		Promocion promo = null;
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
				promo = new PromocionAbsoluta(resultados.getInt(1), atrEnLaPromo, resultados.getString(3),
						TipoAtraccion.valueOf(resultados.getString(4)), resultados.getDouble(6));
				misPromos.add(promo);
			} else if (resultados.getString(5).equals("PORCENTUAL")) {
				promo = new PromocionPorcentual(resultados.getInt(1), atrEnLaPromo, resultados.getString(3),
						TipoAtraccion.valueOf(resultados.getString(4)), resultados.getDouble(6));
				misPromos.add(promo);
			} else {
				promo = new PromocionAxB(resultados.getInt(1), atrEnLaPromo, resultados.getString(3),
						TipoAtraccion.valueOf(resultados.getString(4)));
				misPromos.add(promo);
			}
		}
		
		Integer userId = 9;
		
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		itinerarioService iService = new itinerarioService();
		
		HashMap<String, Producto> mapaAtracciones = (HashMap<String, Producto>) pService.crearMapaAtraccion();
		
		ArrayList<Producto> itinerarioProductos = new ArrayList<Producto>();
		itinerarioProductos.addAll(itinerarioDAO.findItinerarioAtracciones(userId));
		itinerarioProductos.addAll(itinerarioDAO.findItinerarioPromos(mapaAtracciones, userId));
		
		
	}
}