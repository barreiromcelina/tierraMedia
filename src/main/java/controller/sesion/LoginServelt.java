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
import services.loginService;

@WebServlet("/views/login")
public class LoginServelt extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 8419467584778087870L;
	private loginService lService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		lService= new loginService();
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	
    	Usuario user = loginService.login(username, password);
    	
    	if (!user.isNull()) {
    		req.getSession().setAttribute("user", user);
    		resp.sendRedirect("index.jsp");    		
       	} else {
    		req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");
    		
    		RequestDispatcher dispatcher = getServletContext()
      		      .getRequestDispatcher("/views/login.jsp");
      		    dispatcher.forward(req, resp);
    	}
    }
	}

