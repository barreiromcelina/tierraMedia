package controller.productos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import services.promoService;

@WebServlet("/views/promos")
public class FindAllPromoServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -5660211636029789389L;
	private promoService pService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		pService= new promoService();
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Producto> misPromos = pService.obtenerAllPromos();
	
		req.setAttribute("misPromos", misPromos);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promos.jsp");
		dispatcher.forward(req, resp);
	}

}
