<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showing name by parameter</title>
</head>
<body>
	<h1>Esta é a página de recepção do formulário</h1>
	<% String name = request.getParameter("name"); out.print("Nome digitado: " + name); %>
	 <br>
	<% String age = request.getParameter("age"); out.print("Idade digitada: " + age); %>	
</body>
</html>