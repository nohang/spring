<%--
  Created by IntelliJ IDEA.
  User: skplanet
  Date: 13. 3. 5.
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <table>
        <tr>
            <td>Title</td>
            <td>${board.title}</td>
        </tr>
        <tr>
            <td>Writer</td>
            <td>${board.writer}</td>
        </tr>
        <tr>
            <td>Content</td>
            <td>${board.content}</td>
        </tr>
    </table>
    <jsp:include page="footer.jsp">
        <jsp:param name="footer" value="aaa"/>
    </jsp:include>
</body>

</html>