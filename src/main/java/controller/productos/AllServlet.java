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
import model.Usuario;
import services.itinerarioService;
import services.productoService;

@WebServlet("/views/all.do")
public class AllServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3585944019227488981L;
	private productoService prodService;
	private itinerarioService iService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		prodService= new productoService();
		iService = new itinerarioService();
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		List<Producto> all = null;
		
		try {
			all= prodService.obtenerTodoOrdenado(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 List<Producto> itinerarioUser = iService.settearItinerario(user);
			
		req.setAttribute("all", all);
		req.setAttribute("itinerarioUser", itinerarioUser);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/all.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	

}
