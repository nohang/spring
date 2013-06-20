<%--
  Created by IntelliJ IDEA.
  User: skplanet
  Date: 13. 3. 13.
  Time: 오후 2:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title></title>
</head>
<body>
Some error occurred!!
<input type="button" value="Back to list page" onclick="move('/board/logout')" />

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