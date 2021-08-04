<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Sign Up Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sign-up-style.css">
    <script src="${pageContext.request.contextPath}/js/password-confirm.js"></script>
</head>

<body>

<form action="${pageContext.request.contextPath}/sign-up-new" style="border:1px solid #ccc" class="center"
      method="POST">
    <div class="container">
        <%--@declare id="username"--%>
        <%--@declare id="password"--%>
        <%--@declare id="role"--%>
        <%--@declare id="psw-repeat"--%>
        <h1>Sign Up Form</h1>
        <p>Please fill in this form to create an account</p>
        <hr>

        <label for="username"><b>Login</b></label>
        <label>
            <input type="text" placeholder="Enter login" name="username" required>
        </label>

        <label for="password"><b>Password</b></label>
        <label>
            <input type="password" placeholder="Enter password" name="password" id="password"
                   onchange='check_pass();' required>
        </label>

        <label for="psw-repeat"><b>Repeat password</b></label>
        <label>
            <input type="password" placeholder="Repeat password"
                   name="psw-repeat" id="confirm_password"
                   onchange='check_pass();' required>
            <span id='message'></span>
        </label>

        <br>
        <br>

        <label for="role"><b>Select role</b></label>&nbsp;&nbsp;&nbsp;&nbsp;
        <label for="roleDropMenu"></label>
        <select id="roleDropMenu" name="role">
            <option value="user">Viewer</option>
            <option value="admin">Administrator</option>
        </select>

        <div class="clearfix">
            <button type="submit" name="submit" value="registration" id="submit"
                    disabled class="signupbtn">Sign Up
            </button>
        </div>
    </div>
</form>

</body>
</html>
