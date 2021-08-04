<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Access denied</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/buttons.css">
</head>

<body>

<h1>
    Sorry, you don't have permission to view this page
</h1>

<div class="container">
    <button type="button" class="button" style="vertical-align:middle"><a href="javascript:history.back()">Go Back</a>
    </button>
    <button type="button" class="button" style="vertical-align:middle">
        <a href="${pageContext.request.contextPath}/login">Sign In</a>
    </button>
</div>

</body>
</html>
