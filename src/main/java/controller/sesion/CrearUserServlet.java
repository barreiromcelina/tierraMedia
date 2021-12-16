package controller.sesion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TipoAtraccion;
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
		ArrayList<String> tipos = new ArrayList<String>();
				
		tipos = uService.traerTiposPreferidos();
		req.getSession().setAttribute("tipos", tipos);
		/*ArrayList<String> prueba = new ArrayList<String>();
		prueba.add("hola");
		prueba.add("chau");
		req.getSession().setAttribute("pruebas", prueba);*/
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/crearUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("name");
		String contraseña = req.getParameter("password");
		Double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempo"));
		TipoAtraccion tipoPreferido = TipoAtraccion.valueOf(req.getParameter("tipoPreferido"));
		

		Usuario user = uService.create(nombre, contraseña,presupuesto, tiempoDisponible, tipoPreferido);
		req.getSession().setAttribute("user", user);
		req.setAttribute("message", "USUARIO CREADO CON ÉXITO. Vuelva a ingresar usuario y contraseña para acceder");
		if(user.isValid()){
		RequestDispatcher dispatcher = getServletContext()
    		      .getRequestDispatcher("/views/login.jsp");
    		    dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher = getServletContext()
	    		      .getRequestDispatcher("/views/crearUser.jsp");
	    		    dispatcher.forward(req, resp);
		}
	}
}
