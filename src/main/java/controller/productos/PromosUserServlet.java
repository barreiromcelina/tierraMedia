package controller.productos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Usuario;
import services.atraccionService;
import services.itinerarioService;
import services.promoService;


@WebServlet("/views/misPromociones.do")
public class PromosUserServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -2280565863967334432L;
	private promoService pService;
	private atraccionService atrService;
	private itinerarioService iService;

	
	@Override
	public void init() throws ServletException {
		super.init();
		pService= new promoService();
		atrService= new atraccionService();
		iService = new itinerarioService();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		Map<String, Producto> mapAtr=null;
		mapAtr = pService.crearMapaAtraccion();
		 List<Producto> promosUser = pService.obtenerAllPromoOrdenadas(user, (HashMap<String, Producto>)mapAtr);
		 List<Producto> itinerarioUser = iService.settearItinerario(user);
	
		req.setAttribute("promosUser", promosUser);
		req.setAttribute("itinerarioUser", itinerarioUser);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promosUser.jsp");
		dispatcher.forward(req, resp);
}
	}
