<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login | Servlet</title>
</head>
<body>
	<h1>Bem vindo!!!</h1>
	<form action="ServletLogin" method="post">
		<input name="name" placeholder="digite seu usuário" /> <br>
		<input type="password" name="password" placeholder="digite sua senha" /> <br>
		<input type="submit" value="Logar" />
	</form>
	
	<p style="color: red">${msg}</p>
</body>
</html>