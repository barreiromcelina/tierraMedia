package controller.productos;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.comprarPromoService;

@WebServlet("/views/comprarPromo.do")
public class ComprarPromoServlet extends HttpServlet implements Servlet {

	
	private static final long serialVersionUID = -3929090204318138902L;
	private comprarPromoService comprarPromoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		comprarPromoService = new comprarPromoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer promoId = Integer.parseInt(req.getParameter("id"));
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		//El metodo para comprar una promocion esta incompleto
		//Map<String, String> errors = comprarPromoService.comprar(user.getId(), promoId);
		
		
		
		
	}
	
	

}
