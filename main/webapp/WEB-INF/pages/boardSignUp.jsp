<%--
  Created by IntelliJ IDEA.
  User: skplanet
  Date: 13. 6. 20.
  Time: 오전 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:hasBindErrors name="user"/>
<form:errors path="user"/>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/signUp" method="post">
    <table>
        <tr>
            <td>USER NAME</td>
                   <td><input type="text" name="name"></td>

        </tr>
        <tr>
            <td>ID</td>
                    <td><input type="text" name="userid"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="pw"></td>
        </tr>
        <tr>
            <td>NICK NAME</td>
                    <td><input type="text" name="nickname"></td>
        </tr>
        <tr>
            <td><input type="submit" class="button" value="Sign Up"/> </td>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp">
    <jsp:param name="footer" value="aaa"/>
</jsp:include>
</body>
</html>