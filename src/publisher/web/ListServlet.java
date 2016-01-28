package publisher.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publisher.data.NewsItem;
import publisher.data.NewsItemDAO;

@WebServlet(
	urlPatterns ="/list-news-items",
	initParams = @WebInitParam(name="jsp", value="/WEB-INF/jsp/list-items.jsp")
)
public class ListServlet extends ParentServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		logger.debug("list page requested");
		
		NewsItemDAO nidao = new NewsItemDAO();
		List<NewsItem> newsItems = nidao.findAll();
		req.setAttribute("list", newsItems);
		
		jsp.forward(req, resp);
	}

}
