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

@WebServlet("/views/crearPromo.do")
public class CrearPromoServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7276168623847422998L;
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
		ArrayList<String> tiposPromo = new ArrayList<String>();
		List<Producto> atracciones=null;
		ArrayList<String> tiposAtr = new ArrayList<String>();

		tiposAtr = atrService.traerTiposAtraccion();
		req.getSession().setAttribute("tiposAtr", tiposAtr);

		tiposPromo = pService.traerTiposPromocion();
		atracciones = atrService.obtenerAllAtracciones();
		req.getSession().setAttribute("tipos", tiposPromo);
		req.getSession().setAttribute("atracciones", atracciones);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/crearPromo.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("name");
		Double valor = Double.parseDouble(req.getParameter("valor"));
		TipoPromo tipo = TipoPromo.valueOf(req.getParameter("tipo"));
		TipoAtraccion tipoAtr = TipoAtraccion.valueOf(req.getParameter("tipoAtr"));
		String[] atrEnPromo= req.getParameterValues("atrEnPromo");

		Promocion promocion = null;
		if(req.getParameter("tipo").equals("ABSOLUTA")) {
		 promocion = pService.createPromoAbsoluta(nombre, tipo, valor, atrEnPromo, tipoAtr);
		}
		
		if(req.getParameter("tipo").equals("PORCENTUAL")) {
			 promocion = pService.createPromoPorcentual(nombre, tipo, valor, atrEnPromo, tipoAtr);
			}
		
		if(req.getParameter("tipo").equals("A_X_B")) {
			 promocion = pService.createPromoAxB(nombre, tipo, valor, atrEnPromo, tipoAtr);
			}
		
		if(promocion.isValid()) {
		resp.sendRedirect("misPromociones.do");
		}else {
			req.setAttribute("promocion", promocion);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/crearPromo.jsp");
			dispatcher.forward(req, resp);
		}

	}
	

}
