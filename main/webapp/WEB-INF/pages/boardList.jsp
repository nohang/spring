<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <td>${connect} User Connecting</td>
  <table>
       <tr>
           <td>title</td>
           <td>writer</td>
           <td>pw</td>
       </tr>
      <c:forEach var = "board" items="${boards}">
          <tr>
              <td>${board.getId()}</td>
              <td>${board.getTitle()}</td>
              <td>${board.getWriter()}</td>
              <td>${board.getPw()}</td>
              <td> <form method='PUT' action='/board/updateForm'> <input type='hidden' name='id' value='${board.getId()}'/> <input type='submit' value='update'/> </form> </td>
              <td> <form method='POST' action='/board/delete'> <input type='hidden' name='id' value='${board.getId()}'/> <input type='submit' value='delete'/> </form> </td>
              <td> <form method='GET' action='/board/detail'> <input type='hidden' name='id' value='${board.getId()}'/> <input type='submit' value='detail'/> </form> </td>
          </tr>
      </c:forEach>

   </table>
       <input type="button" value="등록" onclick="move('/board/insertForm')" />
       <input type="button" value="logout" onclick="move('/logout')" />

    <script type="text/javascript">
       var move = function(url) {
          location.href = url;
      }
    </script>
  <jsp:include page="footer.jsp">
      <jsp:param name="footer" value="aaa"/>
  </jsp:include>
  </body>
</html>