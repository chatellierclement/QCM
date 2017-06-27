<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="header.jsp" %>
	<title>Insert title here</title>
</head>
<body>

	<h1>Connexion</h1>

	<form action="login" method="POST">
		<label>nom:</label><input name="nom" type="text">
		<label>Passwod</label><input name="prenom" type="password">
		<button type="submit">Connexion</button>
	</form>

</body>
</html>