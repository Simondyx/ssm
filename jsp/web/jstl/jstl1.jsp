<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2021/10/6
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>


<!-- jstl if 标签-->

    <%
        List list = new ArrayList();
        list.add("aaa");
        request.setAttribute("list", list);
    %>

    <c:if test="${not empty list}">
        遍历集合
    </c:if>

<!-- jstl choose 标签-->

<!-- jstl forEach 标签-->



</body>
</html>
