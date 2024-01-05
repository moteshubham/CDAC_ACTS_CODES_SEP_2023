<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
<%--create JB instance n add it under session --%>
<%--<jsp:useBean id="user" class="beans.UserBean" scope="session"/><%--jsp calls JB's ctor --%>
<%--transfer clnt's conversation state to JB --%>
<jsp:setProperty property="*" name="user"/> <%--jsp calls JB ki method means setters call hoge, one way data binding, * matlab sab setters call hoge but matching name wale only, if don't find matchinng setter name it will be null no compile error = no data binding,  --%>
<%--Invoke B.L from JB --%>
<h4>Route : ${sessionScope.user.authenticateUser()}</h4> <%-- session.getAttribute bean id = att name goes in, jaba bean ka getAthenticate user call krega ()ahi matlab methoda hai not property,  --%>
<body>

</body>
</html>