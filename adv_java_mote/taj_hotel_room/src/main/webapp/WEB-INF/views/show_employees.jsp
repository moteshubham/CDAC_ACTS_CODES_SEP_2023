<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Epmloyees</title>
</head>
<body>
	<h5 style="color: red;">${sessionScope.list}</h5>
	<!-- <spring:url var="url" value="/employees/show" /> -->
	 <c:forEach items="${sessionScope.list}" var="ListItem"> <li>${ListItem.name }</li> </c:forEach> 
		<table style="background-color: lightgrey; margin: auto">
		
			<tr>
				<td> First Name</td>
				
				<c:forEach var="abbr" items="${requestScope.list}">
				<td>${employee.firstName }</td>
				
						</c:forEach>
			</tr>
			<tr>
				<td> Last Name</td>
			</tr>
			<tr>
				<td>city</td>
				<td></td>
			</tr>
			<tr>
				<td>company name</td>
				<td></td>
			</tr>
			
			
		</table>

	<%-- <h5>Teams : ${applicationScope.ipl.fetchAllTeams()}</h5> --%>
</body>


</html>