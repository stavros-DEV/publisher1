<%@ include file="top.inc" %>

   <a href="edit-news-item?id=${newsItem.id}">Edit</a>
   <a href="delete-news-item?id=${newsItem.id}">Delete</a>

<%@ include file="middle.inc" %>

<table>
   <tr>
      <td>Title:</td>
      <td>${newsItem.title}</td>

   </tr>
   <tr>
      <td>Url:</td>
      <td>
         ${newsItem.url}
         <a href="${newsItem.url}">test link</a>

      </td>
   </tr>
</table>   

<%@ include file="bottom.inc" %>