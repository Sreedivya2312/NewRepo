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
	<%
		String name = (String) session.getAttribute("name");
	%>
	<form:form method="get" action="PostComment" name="postcomment"
		align="center">
			username : <input type="text" name="username" value=<%=name%> />
			Comments : <input type="text" name="comments" />
		</br>
		<input type="submit" value="post" />
	</form:form>

	<form:form method="get" action="ViewComments" name="viewcomments"
		align="right">
		<input type="submit" value="View" />
	</form:form>
</body>
</html>