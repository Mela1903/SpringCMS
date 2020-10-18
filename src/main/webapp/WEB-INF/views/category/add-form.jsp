<%--
  Created by IntelliJ IDEA.
  User: agaflak
  Date: 18.10.2020
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <div>
        <label for="name">Category Name</label>
        <form:input path="name"/>
    </div>

    <div>
        <label for="description">Description</label>
        <form:input path="description"/>
    </div>

    <input type="submit" value="Submit">
</form:form>


</body>
</html>
