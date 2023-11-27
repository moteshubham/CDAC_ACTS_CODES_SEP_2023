<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="player"/>
<body>
	<%-- invoke playerbeans method n dispay mesf --%>
	<h5>Status mesg : ${sessionScope.player.validateAndAddPlayer() }</h5>
</body>
</html>