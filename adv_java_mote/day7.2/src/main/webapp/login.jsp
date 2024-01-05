<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>

<jsp:useBean id="user" class="beans.UserBean" scope="session"/>

<body>

   <form action="validate.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Enter User Email</td>
          <td><input type="email" name="email" /></td>
        </tr>
        <tr>
          <td>Enter Password</td>
          <td><input type="password" name="pass" /></td>
        </tr>
        <tr>
          <td><input type="submit" value="Login" /></td>
          <td><a href="register.jsp"> Register New Voter</a> </td>
        </tr>
      </table>
    </form>
</body>
</html>