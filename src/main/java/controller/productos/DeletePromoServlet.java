package controller.productos;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.atraccionService;
import services.promoService;

@WebServlet("/views/deletePromo.do")
public class DeletePromoServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 2643213667169798718L;
	private promoService pService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		pService = new promoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		pService.borrarPromo(id);
		

		resp.sendRedirect("index.jsp");
	}
	
	

}
