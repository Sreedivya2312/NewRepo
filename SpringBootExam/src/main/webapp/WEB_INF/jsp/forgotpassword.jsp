<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ForgotPassword</h1>
	<form:form method="get" action="receiver" name="getnewpassword"
		align="center">
 
        Enter Username : <input type="text" name="name" required />
        </br>
		Enter Email :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="mail" required />
		<input type="submit" value="ENTER" />
	</form:form>


</body>
</html>