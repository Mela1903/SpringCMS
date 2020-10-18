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
    <title>List articles</title>
</head>
<body>
Categories:
<table border="1" style="column-rule-width: 40px">
    <tr>
        <th>Lp.</th>
        <th>Title</th>
        <th>Author</th>
        <th>Category</th>
        <th>Content</th>
        <th>Created On</th>
        <th>Updated On</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach items="${articles}" var="art" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${art.title}</td>
            <td>${art.author.firstName} ${art.author.lastName}</td>

            <td>
                <c:forEach items="${art.category}" var="category">
                    ${category.name}<br>
                </c:forEach>
            </td>

            <td>${art.content}</td>
            <td>${art.created.format(formatter)}</td>
            <td>${art.updated}</td>
            <td>
                <a href="">
                    <button style="size: 15px">Edit</button>
                </a>
            </td>
            <td>
                <a href=""/>
                <button style="size: 15px">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
