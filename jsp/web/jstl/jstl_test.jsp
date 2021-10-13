<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dyx.User" %><%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2021/10/6
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--脚本片段，会翻译在Servlet的Service方法中     -->
<%
    List list = new ArrayList();
    list.add(new User("Tom",21));
    list.add(new User("Jerry",23));
request.setAttribute("list", list);
%>

<table border="1" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>

    <%-- EL 存取变量数据的方法很简单，例如：${username}。它的意思是取出某一范围中名称为username的变量。

    因为我们并没有指定哪一个范围的username，所以它的默认值会先从Page 范围找，假如找不到，

    再依序到Request、Session、Application范围。假如途中找到username，就直接回传，不再继续找下去，

    但是假如全部的范围都没有找到时，就回传null，当然EL表达式还会做出优化，页面上显示空白，而不是打印输出NULL。--%>

    <c:forEach items="${list}" var="user" varStatus="s">
    <c:if test="${s.count%2 == 0}">
        <tr bgcolor="#f5f5dc">
            <th>${s.count}</th>
            <th>${user.name}</th>
            <th>${user.age}</th>
        </tr>
    </c:if>
    <c:if test="${s.count%2 == 1}">
        <tr bgcolor="#b8860b">
            <th>${s.count}</th>
            <th>${user.name}</th>
            <th>${user.age}</th>
        </tr>
    </c:if>
    </c:forEach>


</table>



</body>
</html>
