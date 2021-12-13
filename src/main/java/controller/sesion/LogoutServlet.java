package controller.sesion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/views/logout")
public class LogoutServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 6677863159340706929L;
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getSession().removeAttribute("user");
		req.setAttribute("message", "¡Hasta pronto!");
		
		RequestDispatcher dispatcher = getServletContext()
  		      .getRequestDispatcher("/views/login.jsp");
  		    dispatcher.forward(req, resp); 	
    }

}
