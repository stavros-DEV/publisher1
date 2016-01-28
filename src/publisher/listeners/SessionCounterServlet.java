package publisher.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionCounterServlet implements HttpSessionListener
{
	private static int totalActiveSessions;
	private Logger logger = Logger.getLogger(this.getClass());
	
	public static int getTotalActiveSession()
	{
		return totalActiveSessions;
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0)
	{
		totalActiveSessions++;
		logger.debug("Sessions counter, session created ("+arg0.getSession().getId()+") and added to: " + getTotalActiveSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0)
	{
		totalActiveSessions--;
		logger.debug("Sessions counter, session destroyed ("+arg0.getSession().getId()+") and reduced to: " + getTotalActiveSession());
	}
}
