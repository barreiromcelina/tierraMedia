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
import model.Usuario;
import services.userService;

@WebServlet("/views/ListarUsuarios")
public class ListUserAdminServlet extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 5104251447834698643L;
	private userService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userService = new userService();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = userService.traerTodos();
		req.setAttribute("allUsers", usuarios);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/ListaUsuariosAdmin.jsp");
		dispatcher.forward(req, resp);
	}
}
