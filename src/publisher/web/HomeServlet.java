package publisher.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet( urlPatterns = {"/home", "/index.html"} )
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher jsp;
   
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
      	jsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		logger.debug("home page requested");
		jsp.forward(req, resp);
	}
}