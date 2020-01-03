<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">COMMENTS</h1>
	<pre>
		<form:form method="post" action="post" name="register">
		UserName:<input type="text" name="name"">
     Comment:<textarea name="pass" required="" /></textarea>
      <input align="center" type="submit" value="send">
		</form:form>
		
	</pre>

</body>
</html>