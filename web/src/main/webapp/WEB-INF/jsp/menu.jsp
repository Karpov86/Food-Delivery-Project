<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        .btn-group .button {
            background-color: #e3e3e3; /* Green */
            color: #000000;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            cursor: pointer;
            width: 150px;
            display: block;
        }

        .btn-group .button:not(:last-child) {
            border-bottom: none; /* Prevent double borders */
        }

        .btn-group .button:hover {
            background-color: #636363;
        }
    </style>
</head>
<body>
<div style="margin-left: 10%" class="btn-group">
    <p align="center">
    <form action="${pageContext.request.contextPath}menu">
        <button class="button">Pizza</button>
    </form>
    <%--<form action="/visit/surgeon">
        <button class="button">SURGEON</button>
    </form>
    <form action="/visit/cardiologist">
        <button class="button">CARDIOLOGIST</button>
    </form>
    <form action="/visit/gynecologist">
        <button class="button">GYNECOLOGIST</button>
    </form>--%>
</div>
<div>
    <table>

        <c:forEach var="dish" items="${dishes}">
            <tr>
                <td>${dish.name}</td>
                <td>$${dish.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
