<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: skplanet
  Date: 13. 3. 5.
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.skplanet.webhello.myboard.entity.Board" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/board/save" method="post">
    <table>
        <tr>
            <td>Writer</td>
            <td><input type="text" name="writer">
                
            </td>

            <td>Password</td>
            <td><input type="password" name="pw"></td>

        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><textarea name="content" height="100" width="100"></textarea> </td>
        </tr>
        <tr>
            <td><input type="submit" class="button" value="Save"/> </td>
        </tr>
    </table>
</form>
    <jsp:include page="footer.jsp">
        <jsp:param name="footer" value="aaa"/>
    </jsp:include>
</body>
</html>