<%--
  Created by IntelliJ IDEA.
  User: skplanet
  Date: 13. 3. 5.
  Time: 오후 5:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title></title>
</head>
<body>
<spring:hasBindErrors name="board"/>
<form:errors path="board"/>
<form action="/board/update" method="post">
    <table>
        <tr>
            <td>Writer</td>
            <td><input type="text" name="writer" width="0" value="${board.writer}">
                <form:errors path = "board.writer"/>
            </td>


            <td>Password</td>
            <td><input type="password" name="pw" width="0" value=${board.pw}>
            <form:errors path="board.pw"/>
                    </td>

        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" width="0" value=${board.title}>
                <form:errors path="board.title"/>
            </td>
        </tr>
        <tr>
            <td>Content</td>
            <td><textarea name="content" height="100" width="100" >${board.content}</textarea>
                <form:errors path="board.content"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" class="button" value="Save"/> </td>
        </tr>
    </table>
    <input type="hidden" name="id" value=${board.id}>
</form>

<jsp:include page="footer.jsp">
    <jsp:param name="footer" value="aaa"/>
</jsp:include>
</body>
</html>