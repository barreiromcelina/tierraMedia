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
import model.TipoAtraccion;
import model.Usuario;
import services.atraccionService;
import services.userService;

@WebServlet("/views/EditarUsuario.do")
public class EditUsersAdminServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1308497590380647577L;
	private userService userService;
	private atraccionService atrService;

	@Override
	public void init() throws ServletException {
		super.init();
		userService = new userService();
		atrService = new atraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		ArrayList<String> tipos = new ArrayList<String>();

		Usuario usuario = userService.obtenerUsuarioPorId(userId);
		tipos = atrService.traerTiposAtraccion();

		req.getSession().setAttribute("tipos", tipos);
		req.setAttribute("usuario", usuario);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/EditUsuarioAdmin.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		Boolean admin = Boolean.valueOf(req.getParameter("admin"));
		String nombre = req.getParameter("name");
		String contraseña = req.getParameter("password");
		Double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		TipoAtraccion tipoPreferido = TipoAtraccion.valueOf(req.getParameter("tipoPreferido"));

		Usuario usuarioEditado = userService.edit(userId, admin, nombre, contraseña, presupuesto, tiempoDisponible, tipoPreferido);
		
		if (usuarioEditado.isValid()) {
			resp.sendRedirect("/tierraMedia/views/ListarUsuarios");
		} else {
			req.setAttribute("usuario", usuarioEditado);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/EditUsuarioAdmin.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
