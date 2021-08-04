<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Search</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/search-style.css">
</head>

<body>

<form name="search" action="${pageContext.request.contextPath}/user/sensors-search-result" method="post">

    <div class="flex">
        <div>
            <div class="input-group">
                <label>
                    <input type="text" name="search" placeholder="Enter text to search"/>
                </label>
                <input type="submit" value="Search" name="find"/>
            </div>
        </div>
    </div>

</form>

</body>
</html>
