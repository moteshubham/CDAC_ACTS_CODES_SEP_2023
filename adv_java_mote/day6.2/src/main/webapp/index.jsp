<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Session ID : <%= session.getId() %></h3>
	<h4>
		Welcome 2 JSP !!!!!!
		<%=LocalDateTime.now()%></h4>
	<h5>
		<a href="comments.jsp">Testing JSP Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">Testing Scriptlets</a>
	</h5>
</body>
</html>