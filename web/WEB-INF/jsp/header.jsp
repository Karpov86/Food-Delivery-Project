<%--
  Created by IntelliJ IDEA.
  User: karpo
  Date: 29.03.2020
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal"><a href="/">Food delivery</a></h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="${pageContext.request.contextPath}register">Registration</a>
        <a class="p-2 text-dark" href="#">Some tab</a>
        <a class="p-2 text-dark" href="#">Some tab</a>
        <a class="p-2 text-dark" href="#">Contacts</a>
        <a class="p-2 text-dark" href="#">About</a>
    </nav>
    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}login">Sign up</a>
</div>
</body>
</html>
