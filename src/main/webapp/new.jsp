<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create new meal</title>
</head>

<form action="new.jsp" method="POST">
    <label>
        Description:
        <input type="text" name="first_name">
    </label>
    <br/>
    <label>
        Calories:
        <input type="text" name="last_name"/>
    </label>
    <input type="submit" value="Submit"/>
</form>
<body>

</body>
</html>
