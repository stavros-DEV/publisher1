<%@ page import="java.util.Iterator" %> 
<%@ page import="publisher.data.NewsItem" %>
<%@ page import="publisher.data.User" %>
<jsp:useBean id="list" scope="request" type="java.util.List<NewsItem>" />
<jsp:useBean id="user" class="publisher.data.User" scope="session"/>

<%@ include file="top.inc" %>
	<p>Welcome <%=user.getUsername()%></p>
	<a href="create-news-item">Create News Item</a>
<%@ include file="middle.inc" %>
	<ul>
		<%
			Iterator<NewsItem> it = list.iterator();
			while(it.hasNext()){
				NewsItem nf = (NewsItem) it.next();
		%>
				<li>
					<a href="view-news-item?id=<%=nf.getId()%>"><%=nf.getTitle()%></a>(<%=nf.getUrl()%>)
				</li>
		<%
			}
		%>
	</ul>
	
<%@ include file="bottom.inc" %>