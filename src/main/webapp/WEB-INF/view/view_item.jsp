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
    <title>View Items</title>
</head>
<body>
        <div align="center">
            <table>
                <tr>
                    <td><label>ID</label></td>
                    <td><c:out value="${todoItem.id}"/></td>
                </tr>
                <tr>
                   <td><label>Title</label></td>
                   <td><c:out value="${todoItem.title}"/></td>
                </tr>
                <tr>
                   <td><label>Deadline</label></td>
                   <td><c:out value="${todoItem.deadline}"/></td>
                </tr>
                <tr>
                   <td><label>Details</label></td>
                   <td><c:out value="${todoItem.details}"/></td>
                </tr>
            </table>

            <c:url var="tableUrl" value="${Mappings.ITEMS}"/>
            <a href="${tableUrl}">Show Table</a>
        </div>
</body>
</html>
