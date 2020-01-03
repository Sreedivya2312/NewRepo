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
	<form:form action="updatepassword" name="getnewpassword" align="center">
				Enter Email :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text"
			name="mail1" required />
		
       Enter NewPassword : <input type="password" name="pass" required />
		</br>
		<input type="submit" value="ENTER" />
	</form:form>
</body>
</html>