<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%--  --%>
<jsp:setProperty property="*" name="user"/>
<body>
<%-- invoke business logic method for voter reg  --%>
<h4>Status : ${sessionScope.user.registerNewVoter()}</h4> <%-- session scope is attrr map --%>
</body>
</html>