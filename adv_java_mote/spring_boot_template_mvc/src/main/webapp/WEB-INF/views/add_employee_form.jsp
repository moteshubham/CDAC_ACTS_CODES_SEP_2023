<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Epmloyees</title>
</head>
<body>
	<h5 style="color: red;">${sessionScope.mesg }</h5>
	<spring:url var="url" value="/employees/add" />
	<form:form action="${url}" method="post" modelAttribute="employee">
		<table style="background-color: lightgrey; margin: auto">
		
			<tr>
				<td>Enter First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>city</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>company name</td>
				<td><form:input path="companyName" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Add A Employee" /></td>
			</tr>
		</table>
	</form:form>
	<%-- <h5>Teams : ${applicationScope.ipl.fetchAllTeams()}</h5> --%>
</body>


</html>