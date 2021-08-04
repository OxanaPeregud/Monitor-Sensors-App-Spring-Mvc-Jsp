<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Sensor Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/form.css">
    <script src="${pageContext.request.contextPath}/js/validation.js"></script>
</head>

<body>

<button type="button" class="button"><a class="homepage"
                                        href="${pageContext.request.contextPath}/user/sensors-list">Cancel</a>
</button>

<div>
    <c:if test="${sensor != null}">
    <form name="sensorForm" onsubmit="return validateForm()"
          action="${pageContext.request.contextPath}/admin/update-sensor" method="post">
        </c:if>

        <c:if test="${sensor == null}">
        <form name="sensorForm" onsubmit="return validateForm()"
              action="${pageContext.request.contextPath}/admin/insert-sensor" method="post">
            </c:if>

            <caption>
                <h2>Sensor Information</h2>
            </caption>

            <c:if test="${sensor != null}">
                <input type="hidden" name="id" value="<c:out value='${sensor.id}' />"/>
            </c:if>

            <div class="row">
                <label>Name</label>
                <label>
                    <input type="text" placeholder="Name" name="name" maxlength="30"
                           value="<c:out value='${sensor.name}' />"
                    />
                </label>
                <div class="error" id="nameErr"></div>
            </div>

            <div class="row">
                <label>Model</label>
                <label>
                    <input type="text" placeholder="Model" name="model" maxlength="15"
                           value="<c:out value='${sensor.model}' />"
                    />
                </label>
                <div class="error" id="modelErr"></div>
            </div>

            <div class="row">
                <label>Range From</label>
                <label>
                    <input type="text" name="rangeFrom"
                           value="<c:out value='${sensor.rangeFrom}' />"
                    />
                </label>
            </div>

            <div class="row">
                <label>Range To</label>
                <label>
                    <input type="text" name="rangeTo"
                           value="<c:out value='${sensor.rangeTo}' />"
                    />
                </label>
                <div class="error" id="rangeErr"></div>
            </div>

            <div class="row">
                <label>Type</label>
                <label for="dropMenu1"></label>
                <select id="dropMenu1" name="type">
                    <option value="" disabled selected>Select</option>
                    <c:forEach var="type" items="${listTypes}">
                        <option value="${type}"><c:out value="${type}"/></option>
                    </c:forEach>
                </select>
                <div class="error" id="typeErr"></div>
            </div>

            <div class="row">
                <label>Unit</label>
                <label for="dropMenu2"></label>
                <select id="dropMenu2" name="unit">
                    <option value="" disabled selected>Select</option>
                    <c:forEach var="unit" items="${listUnits}">
                        <option value="${unit}"><c:out value="${unit}"/></option>
                    </c:forEach>
                </select>
                <div class="error" id="unitErr"></div>
            </div>

            <div class="row">
                <label>Location</label>
                <label>
                    <input type="text" placeholder="Location" name="location" maxlength="40"
                           value="<c:out value='${sensor.location}' />"
                    />
                </label>
            </div>

            <div class="row">
                <label>Description</label>
                <label>
                            <textarea type="text" placeholder="Description" name="description" cols="94" rows="10"
                                      maxlength="200" value="<c:out value='${sensor.description}' />"></textarea>
                </label>
            </div>

            <div class="row">
                <input type="submit" value="Submit">
            </div>
        </form>
    </form>

</div>
</body>
</html>
