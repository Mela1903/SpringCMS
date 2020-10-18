<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: agaflak
  Date: 11.10.2020
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List categories</title>
</head>
<body>
Categories:
<table border="1" style="column-rule-width: 40px">
    <tr>
        <th>Lp.</th>
        <th>Name</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach items="${categories}" var="cat" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${cat.name}</td>
            <td>${cat.description}</td>
            <td>
                <a href="/cat/edit/${cat.id}">
                    <button style="size: 15px">Edit</button>
                </a>
            </td>
            <td>
                <a href="/cat/delete/${cat.id}"/>
                <button style="size: 15px">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
