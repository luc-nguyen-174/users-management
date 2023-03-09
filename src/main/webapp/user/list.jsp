<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <h2>LIST OF USERS</h2>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Province</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.province.province_name}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
