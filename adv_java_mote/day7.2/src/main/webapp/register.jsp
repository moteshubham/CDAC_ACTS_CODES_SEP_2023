<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="voter_registration.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Enter First Name</td>
          <td><input type="text" name="fname" /></td>
        </tr>
        <tr>
          <td>Enter Last Name</td>
          <td><input type="text" name="lname" /></td>
        </tr>
        <tr>
          <td>Enter User Email</td>
          <td><input type="text" name="email" /></td>
        </tr>
        <tr>
          <td>Enter Password</td>
          <td><input type="password" name="pass" /></td>
        </tr>
        <tr>
          <td>Enter DoB</td>
          <td><input type="date" name="dob" /></td>
        </tr>

        <tr>
          <td><input type="submit" value="Sign Up" /></td>
        </tr>
      </table>
    </form>
</body>
</html>