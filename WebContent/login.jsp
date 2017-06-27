<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="header.jsp" %>
	<title>Insert title here</title>
</head>
<body>

	<% if( request.getAttribute("error") != null && (Boolean) request.getAttribute("error")){ %>
					<div class="alert alert-danger" role="alert">
						  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
						  <span class="sr-only">Error:</span>
						  fezfef
					</div> 
	<%} %>
	
	
	
	<h1>Connexion</h1>


	<form action="login" method="POST">
		<label>nom:</label><input name="nom" type="text">
		<label>Password</label><input name="prenom" type="password">
		<button type="submit">Connexion</button>
	</form>

</body>
</html>