package controller.productos;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.TipoAtraccion;
import services.atraccionService;

@WebServlet("/views/editAtr.do")
public class EditAtrServlet extends HttpServlet implements Servlet {

	
	private static final long serialVersionUID = -4618458564833294081L;
	private atraccionService atrService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		atrService  = new atraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer atrId = Integer.parseInt(req.getParameter("id"));
		ArrayList<String> tipos = new ArrayList<String>();
		
		
		Atraccion atraccion = atrService.find(atrId);
		tipos = atrService.traerTiposAtraccion();
		
		
		req.getSession().setAttribute("tipos", tipos);
		req.setAttribute("atraccion", atraccion);
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/editarAtr.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("name");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		

		Atraccion atraccion = atrService.update(id, nombre, costo, cupo, tiempo);
		if(atraccion.isValid()) {
			resp.sendRedirect("misAtracciones.do");
			} else {
				req.setAttribute("atraccion", atraccion);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/crearAtraccion.jsp");
				dispatcher.forward(req, resp);
			}
		
	}
	
	

}
