<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>Name</th>
            <th>Category</th>
            <th>Specialty</th>
        </tr>

        <c:forEach var="dish" items="${dishes}">
            <tr>
                <td>${dish.name}</td>
                <td>${dish.category}</td>
                <td>${dish.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
