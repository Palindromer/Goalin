<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Goal Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Goal
</h1>

	<c:url var="addAction" value="/goal/add" ></c:url>

<form:form action="${addAction}" commandName="goal">
<table>
	<c:if test="${!empty goal.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty goal.name}">
				<input type="submit"
					value="<spring:message text="Edit Goal"/>" />
			</c:if>
			<c:if test="${empty goal.name}">
				<input type="submit"
					value="<spring:message text="Add Goal"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Goals List</h3>
<c:if test="${!empty listGoals}">
	<table class="tg">
	<tr>
		<th width="80">Goal ID</th>
		<th width="120">Goal Name</th>
		<th width="120">Goal Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listGoals}" var="goal">
		<tr>
			<td>${goal.id}</td>
			<td>${goal.name}</td>
			<td>${goal.description}</td>
			<td><a href="<c:url value='/goal/edit/${goal.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/goal/remove/${goal.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
