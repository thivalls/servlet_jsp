<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ops!!!</h1>
	<h3>alguma coisa deu errada.</h3>
	<p>
		<% out.print(request.getAttribute("message")); %>
	</p>
</body>
</html>