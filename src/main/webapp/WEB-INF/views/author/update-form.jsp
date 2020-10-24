<%--
  Created by IntelliJ IDEA.
  User: agaflak
  Date: 18.10.2020
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Update Author</title>
</head>
<body>
Update Author:
<form:form method="post" action="/aut/update" modelAttribute="author">

    <form:input type="hidden" path="id" value="${authorEdited.id}"/>
    <div>
        <label for="firstName">First Name</label>
        <form:input path="firstName" value="${authorEdited.firstName}"/>
    </div>
    <div>
        <label for="lastName">Last Name</label>
        <form:input path="lastName" value="${authorEdited.lastName}"/>
    </div>

    <input type="submit" value="Submit">

</form:form>


</body>
</html>
