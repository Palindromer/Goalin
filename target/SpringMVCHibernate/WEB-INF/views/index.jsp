<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
    <h1>Hello!</h1>


    <a href="<c:url value="/person/"/>">Persons</a><br/>
    <a href="<c:url value="/goal/"/>">Goals</a>


</body>
</html>
