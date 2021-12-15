package controller.productos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Promocion;
import model.TipoAtraccion;
import model.TipoPromo;
import services.atraccionService;
import services.promoService;

@WebServlet("/views/editPromo.do")
public class EditPromoServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 819938021765633226L;
	private promoService pService;
	private atraccionService atrService;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		pService= new promoService();
		atrService = new atraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer pId = Integer.parseInt(req.getParameter("id"));
		Promocion promocion = pService.find(pId);
		ArrayList<String> tiposPromo = new ArrayList<String>();
		List<Producto> atracciones=null;
		ArrayList<String> tiposAtr = new ArrayList<String>();

		tiposAtr = atrService.traerTiposAtraccion();
		req.getSession().setAttribute("tiposAtr", tiposAtr);

		tiposPromo = pService.traerTiposPromocion();
		atracciones = atrService.obtenerAllAtracciones();
		req.setAttribute("promocion", promocion);
		req.getSession().setAttribute("tipos", tiposPromo);
		req.getSession().setAttribute("atracciones", atracciones);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/editarPromo.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("name");
		Double valor = Double.parseDouble(req.getParameter("valor"));
		TipoPromo tipo = TipoPromo.valueOf(req.getParameter("tipo"));
		String[] atrEnPromo= req.getParameterValues("atrEnPromo");

		pService.update(id, nombre, tipo, valor, atrEnPromo);
		resp.sendRedirect("misPromociones.do");

	}

}
