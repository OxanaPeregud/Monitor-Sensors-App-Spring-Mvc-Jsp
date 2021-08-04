<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Login failed</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login-style.css">
</head>

<h2 align="center">
    Incorrect Name or Password!
</h2>

<body class="text-center">

<form class="center" action="${pageContext.request.contextPath}/login" method="POST">

    <div class="imgcontainer">
        <img src="samuel.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <%--@declare id="username"--%><%--@declare id="password"--%>
        <label for="username"><b>Login</b></label>
        <label>
            <input type="text" placeholder="Your login" name="username" required>
        </label>

        <label for="password"><b>Password</b></label>
        <label>
            <input type="password" placeholder="Your password" name="password" required>
        </label>

        <button type="submit">Sign In</button>
        <br>
        <div style="text-align: center;"><a href="${pageContext.request.contextPath}/sign-up-page">Sign Up</a></div>

    </div>

</form>

</body>
</html>
