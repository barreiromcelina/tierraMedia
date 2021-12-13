package controller.productos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
import services.userService;

@WebServlet("/views/misAtracciones.do")
public class AtraccionUser extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 9197858196736103965L;
	private atraccionService atrService;
	private itinerarioService iService;
	

	@Override
	public void init() throws ServletException {
		super.init();
		atrService  = new atraccionService();
		iService = new itinerarioService();
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		List<Producto> atraccionesUser=null;
		

		 atraccionesUser = atrService.obtenerAllAtraccionesOrdenadas(user);
		 List<Producto> itinerarioUser = iService.settearItinerario(user);
	
		req.setAttribute("atraccionesUser", atraccionesUser);
		req.setAttribute("itinerarioUser", itinerarioUser);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/atraccionesUser.jsp");
		dispatcher.forward(req, resp);
		
	}

}
