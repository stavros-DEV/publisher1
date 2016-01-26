package publisher.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class ParentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected Logger logger = Logger.getLogger(this.getClass());
	protected RequestDispatcher jsp;
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext context = config.getServletContext();
		jsp = context.getRequestDispatcher(config.getInitParameter("jsp"));
	}
}
