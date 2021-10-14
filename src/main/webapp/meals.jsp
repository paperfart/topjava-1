<%@ page contentType="text/html;charset=UTF-8" %>
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
            <th>Description</th>
            <th>Calories</th>
        </tr>
        <c:forEach var="meal" items="${meals.rows}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.profession}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>