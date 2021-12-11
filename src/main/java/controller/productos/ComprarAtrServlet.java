package controller.productos;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.comprarAtrService;

@WebServlet("/views/comprarAtr.do")
public class ComprarAtrServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 2801734433490621512L;
	private comprarAtrService comprarAtrService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		comprarAtrService = new comprarAtrService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer atrId = Integer.parseInt(req.getParameter("id"));
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		Map<String, String> errors = comprarAtrService.comprar(user.getId(), atrId);
		
		
		  Usuario user2 = DAOFactory.getUsuarioDAO().find(user.getId());
		  req.getSession().setAttribute("user", user2);
		 
		
		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/itinerario.do");
		dispatcher.forward(req, resp);
	}

}
