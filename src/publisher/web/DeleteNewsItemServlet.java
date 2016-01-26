package publisher.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publisher.data.NewsItem;
import publisher.data.NewsItemDAO;

public class DeleteNewsItemServlet extends ParentServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		logger.debug("doGet()");
	    jsp.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	   throws ServletException, IOException
	   {
	      String idString = req.getParameter("id");
	      
	      if (req.getParameter("cancel-button") != null)
	      {
	         logger.debug("cancel button pressed");
	         resp.sendRedirect("view-news-item?id=" + idString);
	         return;
	      }

	      NewsItemDAO newsItemDAO = new NewsItemDAO();
	      Long id = new Long(idString);
	      NewsItem newsItem = newsItemDAO.find(id);
	      new NewsItemDAO().delete(newsItem);
	      resp.sendRedirect("list-news-items");
	   }

}
