<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Sensor Table</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/hint.css">
</head>

<body>

<button type="button" class="button2"><a class="homepage" href="${pageContext.request.contextPath}/logout">Sign Out</a>
</button>

<body style="text-align:center;">

<button type="button" class="button3"><a class="homepage"
                                         href="${pageContext.request.contextPath}/admin/sensor-add">Add Sensor</a>
</button>


<div>
    <h1>Sensor Table</h1>
</div>

<br>
<br>
<br>

<div>

    <%@include file="sensor-search.jsp" %>

    <form action="${pageContext.request.contextPath}/admin/delete-sensors" method="post">
        <table id="customers">

            <caption><h2>Sensors</h2></caption>
            <tr>
                <th></th>
                <th>Name</th>
                <th>Model</th>
                <th>Type</th>
                <th>Range From</th>
                <th>Range To</th>
                <th>Unit</th>
                <th>Location</th>
                <th></th>
            </tr>

            <c:forEach var="sensor" items="${listSensors}">

                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/edit-sensor?id=<c:out value='${sensor.id}'/>">
                            Edit</a>
                    </td>

                    <td>
                        <div class="tooltip"><c:out value="${sensor.name}"/>
                            <span class="tooltiptext">${sensor.description}</span>
                        </div>
                    </td>

                    <td><c:out value="${sensor.model}"/></td>
                    <td><c:out value="${sensor.type}"/></td>
                    <td><c:out value="${sensor.rangeFrom}"/></td>
                    <td><c:out value="${sensor.rangeTo}"/></td>
                    <td><c:out value="${sensor.unit}"/></td>
                    <td><c:out value="${sensor.location}"/></td>
                    <td>
                        <label><input type="checkbox" name="deleteSensor"
                                      value="${sensor.id}">Delete</label>
                    </td>
                </tr>
            </c:forEach>

            <tr class="right">
                <td>
                    <input type="submit" value="Delete"/>
                </td>
            </tr>

        </table>
    </form>

    <button type="button" class="button2">
        <a class="homepage" href="${pageContext.request.contextPath}/user/sensors-list">Go to full Sensor list</a>
    </button>

</div>
</body>
</html>
