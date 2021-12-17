package controller.productos;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.userService;

@WebServlet("/views/deleteUser.do")
public class DeleteUsersAdminServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3700634972180151308L;
	private userService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		userService = new userService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer userId = Integer.parseInt(req.getParameter("userId"));

		userService.borrar(userId);
		resp.sendRedirect("/tierraMedia/views/ListarUsuarios");
	}
	
	
	
}
