package controller.sesion;

import java.io.IOException;
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
import services.itinerarioService;

@WebServlet("/views/itinerario.do")
public class ItinerarioServelt extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -5750708705066953290L;
	private itinerarioService iService;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		iService = new itinerarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		String miItinerario=null;
		

		 miItinerario = iService.obtenerItinerario(user);
		 Integer costoTotal = iService.obtenerCostoTotal(user);
		 Integer tiempoTotal = iService.obtenerTiempoTotal(user);
		 
		 
	
		req.setAttribute("miItinerario", miItinerario);
		req.setAttribute("costoTotal", costoTotal);
		req.setAttribute("tiempoTotal", tiempoTotal);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/itinerario.jsp");
		dispatcher.forward(req, resp);
	}

}
