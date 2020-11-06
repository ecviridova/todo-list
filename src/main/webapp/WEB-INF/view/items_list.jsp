<%--
  Created by IntelliJ IDEA.
  User: Kate
  Date: 02.07.2020
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.myapp.todolist.util.Mappings" %>

<html>
<head>
    <title>Todo Items</title>
</head>
<body>
        <div align="center">
        <c:url var="addUrl" value="${Mappings.ADD_ITEM}"/>
        <a href="${addUrl}">NewItem</a>

            <table border="1" cellpadding="5">

            <caption><h2>Todo Items</h2></caption>

            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>View</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="item" items="${todoData.items}">

                <c:url var="editUrl" value="${Mappings.ADD_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="viewUrl" value="${Mappings.VIEW_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${viewUrl}">View</a></td>
                    <td><a href="${editUrl}">Edit</a></td>
                    <td><a href="${deleteUrl}">Delete</a></td>
                </tr>
            </c:forEach>
        </div>


</body>
</html>
