<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Session ID :
		<%=session.getId()%></h3>
	<h3 align="center">Via JSP Scriptlet</h3>
	<%
	//JSP scriptlet
	String email = request.getParameter("em");
	String password = request.getParameter("pass");
	out.print("<h4>Email " + email + "</h4>");
	out.print("<h4>PWD " + password + "</h4>");
	%>
	<hr />
	<h3 align="center">Via JSP Expression</h3>
	<h4>
		Email :
		<%=request.getParameter("em")%></h4>
	<h4>
		Password :
		<%=request.getParameter("pass")%></h4>
		<hr/>
		<h3 align="center">Via JSP EL Syntax</h3>
		<h4>
		Email : ${param.em}
		</h4>
		<h4>
		Password : ${param.pass}
		</h4>
		<h4>
		param : ${param}
		</h4>
</body>
</html>