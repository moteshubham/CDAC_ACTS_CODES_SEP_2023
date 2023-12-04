<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Page</title>
</head>
<body>
	<h5>
		<spring:url var="url" value="/employees/add" />
		<a href="${url}">add Employee</a>
	</h5>
	<h5>
	<spring:url var="url" value="/employees/show" />
		<a href="${url}">view Employee</a>
	</h5>
	<h5>
	<spring:url var="url" value="/employees/add" />
		<a href="test">display Employee</a>
	</h5>

</body>
</html>