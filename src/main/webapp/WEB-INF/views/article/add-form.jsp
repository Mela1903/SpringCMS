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
<form:form method="post" modelAttribute="article">
    <div>
        <label for="name">Article Title</label>
        <form:input path="name"/>
    </div>

    <div>
        <label for="author">Author - choose from drop-down list</label>
        <form:select path="author.id" items="${authors}" id="author" itemLabel="firstName" itemValue="id"/>
    </div>

    <div>
        <label for="categories">Categories</label>
        <form:select multiple="true" path="categories.name">
        <form:options items="${categories}" id="categories" itemLabel="name" itemValue="id"/>
        </form:select>
    </div>





    <input type="submit" value="Submit">
</form:form>


</body>
</html>
