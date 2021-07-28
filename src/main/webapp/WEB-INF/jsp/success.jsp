<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/buttons.css">
</head>

<body>

<h1>
    You are successfully Signed Up!
</h1>

<div class="container">
    <button type="button" class="button" style="vertical-align:middle"><a
            href="${pageContext.request.contextPath}/login">Sign In</a>
    </button>
</div>

</body>
</html>
