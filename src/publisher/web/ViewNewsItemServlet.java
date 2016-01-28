package publisher.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publisher.data.NewsItem;
import publisher.data.NewsItemDAO;

@WebServlet(
	urlPatterns ="/view-news-item",
	initParams = @WebInitParam(name="jsp", value="/WEB-INF/jsp/view-news-item.jsp")
)
public class ViewNewsItemServlet extends ParentServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		logger.debug("ViewNewsItemServlet - doGet()");
		Long ln = new Long(req.getParameter("id"));
		NewsItem newsItem = new NewsItemDAO().find(ln);
		if(newsItem == null){
			resp.sendRedirect("list-news-items");
			return;
		}
		req.setAttribute("newsItem", newsItem);
		jsp.forward(req, resp);
	}
}
