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

@WebServlet("/views/crearAtr.do")
public class CrearAtrServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -4439608187594261236L;
	private atraccionService atrService;

	@Override
	public void init() throws ServletException {
		super.init();
		atrService = new atraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> tipos = new ArrayList<String>();

		tipos = atrService.traerTiposAtraccion();
		req.getSession().setAttribute("tipos", tipos);
		/*
		 * ArrayList<String> prueba = new ArrayList<String>(); prueba.add("hola");
		 * prueba.add("chau"); req.getSession().setAttribute("pruebas", prueba);
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/crearAtraccion.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("name");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		TipoAtraccion tipo = TipoAtraccion.valueOf(req.getParameter("tipo"));

		
		Atraccion atraccion = atrService.create(nombre, costo, cupo, tiempo, tipo);
		if(atraccion.isValid()) {
		resp.sendRedirect("misAtracciones.do");}
		else {
			req.setAttribute("atraccion", atraccion);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/crearAtraccion.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
