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
import services.atraccionService;

@WebServlet("/atracciones.do")
public class AllAtraccionServlet extends HttpServlet implements Servlet{

	private static final long serialVersionUID = -7079007108065794584L;
	private atraccionService atrService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		atrService  = new atraccionService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Producto> misAtracciones = null;
		try {
			misAtracciones = atrService.obtenerAllAtracciones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("misAtracciones", misAtracciones);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("../views/atracciones.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
