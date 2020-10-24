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
    <title>List authors</title>
</head>
<body>
Authors:
<table border="1" style="column-rule-width: 40px">
    <tr>
        <th>Lp.</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach items="${authors}" var="aut" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${aut.firstName}</td>
            <td>${aut.lastName}</td>


            <td>
                <a href="/aut/edit/${aut.id}">
                    <button style="size: 15px">Edit</button>
                </a>
            </td>
            <td>
                <a href="/aut/delete/${aut.id}"/>
                <button style="size: 15px">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
