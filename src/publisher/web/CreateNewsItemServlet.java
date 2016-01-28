package publisher.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publisher.data.NewsItem;
import publisher.data.NewsItemDAO;

@WebServlet(
	urlPatterns ="/create-news-item",
	initParams = @WebInitParam(name="jsp", value="/WEB-INF/jsp/edit-news-item.jsp")
)
public class CreateNewsItemServlet extends ParentServlet
{
	private static final long serialVersionUID = 1L;
   
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      logger.debug("doGet()");
      jsp.forward(req, resp);
   }

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
   throws ServletException, IOException
   {
      // Check if cancel button was pressed.
      String cancelButton = req.getParameter("cancel-button");
      if (cancelButton != null)
      {
         logger.debug("cancel button pressed");
         resp.sendRedirect("list-news-items");
         return;
      }
      Map<String, String> errors = EditNewsItemServlet.validate(req);
      if (!errors.isEmpty())
      {
         logger.debug("validation errors");
         jsp.forward(req, resp);
         return;
      }

      NewsItem newsItem = (NewsItem) req.getAttribute("newsItem");
      new NewsItemDAO().create(newsItem);
      resp.sendRedirect("view-news-item?id=" + newsItem.getId());
   }
}