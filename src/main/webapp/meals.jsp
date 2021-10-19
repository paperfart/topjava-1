<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of meals</h2></caption>
        <tr>
            <th>Date</th>
            <th>Name</th>
            <th>Calories</th>
        </tr>
        <%--@elvariable id="mealList" type="java.util.List"--%>
        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
            <tr style=${meal.excess ? "background-color:#D76C55" : "background-color:#68EFA1"}>
                <td><%= TimeUtil.printTime(meal.getDateTime())%>
                </td>
                <td><c:out value=" ${meal.description}"/></td>
                <td><c:out value=" ${meal.calories}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>