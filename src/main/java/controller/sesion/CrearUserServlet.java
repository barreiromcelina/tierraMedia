package controller.sesion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.userService;



@WebServlet("/views/crearUser")
public class CrearUserServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1741548063861183982L;
	private userService uService;

	@Override
	public void init() throws ServletException {
		super.init();
		uService= new userService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/crearUser.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("name");
		String contraseña = req.getParameter("password");
		

		Usuario user = uService.create(nombre, contraseña);
			resp.sendRedirect("/tierraMedia/views/index.jsp");
		
	}
}
