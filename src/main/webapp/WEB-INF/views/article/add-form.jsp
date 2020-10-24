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
<form:form method="post" modelAttribute="article">
    <div>
        <label for="title">Article Title</label>
        <form:input path="title"/>
        <form:errors path="title" cssStyle="color: coral"/>
    </div>

    <div>
        <label for="author">Author - choose from drop-down list</label>
        <form:select path="author" items="${authors}" id="author" itemValue="id"/>
        <form:errors path="author" cssStyle="color: coral"/>

    </div>

    <div>
        <label>Category</label>
        <c:forEach items="${categories}" var="categoryItem">
            <form:checkbox path="category" label="${categoryItem.name}" value="${categoryItem.id}" multiple="true"/>

        </c:forEach>
        <div>
            <form:errors path="category" cssStyle="color: coral"/>
        </div>
    </div>

    <div>
        <label for="content">Content</label>
        <form:textarea path="content"/>
        <form:errors path="content" cssStyle="color: coral"/>

    </div>


    <input type="submit" value="Submit">
</form:form>


</body>
</html>
