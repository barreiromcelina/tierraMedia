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


@WebServlet("/views/deleteAtr.do")
public class DeleteAtraccionServlet extends HttpServlet implements Servlet {


	private static final long serialVersionUID = 7944290963509329929L;
	private atraccionService atrService;
	private promoService pService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		atrService = new atraccionService();
		pService = new promoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		atrService.borrar(id);
		pService.borrar(id);
		

		resp.sendRedirect("index.jsp");
	}
	
	

}
