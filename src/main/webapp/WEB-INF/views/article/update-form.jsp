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
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/art/update" modelAttribute="article">

    <form:input type="hidden" path="id" value="${articleEdited.id}"/>
    <div>
        <label for="title">Category Name</label>
        <form:input path="title" value="${articleEdited.title}"/>
    </div>

    <div>
        <label for="author">Author - update</label>
        <form:select path="author" items="${authors}" id="author" itemValue="id" value="${articleEdited.author}"/>
    </div>

    <div>
        <label>Category</label>
        <c:forEach items="${categories}" var="categoryItem">
            <form:checkbox path="category" label="${categoryItem.name}" value="${categoryItem.id}" multiple="true"/>
        </c:forEach>
    </div>

    <div>
        <label for="content">Content</label>
        <form:input path="content" value="${articleEdited.content}"/>
    </div>

    <input type="submit" value="Submit">

</form:form>


</body>
</html>
