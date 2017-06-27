<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/login.css" />
<link href="https://fonts.googleapis.com/css?family=Roboto:300"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300"
	rel="stylesheet">

</head>
<body>


	<div class="wrapper">

		<h1>Connexion</h1>
		<br>
		<div class="content">
			<form action="login" method="POST">
				<div class="form-group">
					<label>nom</label> <input name="nom" type="text">
				</div>
				<div class="form-group">
					<label>Password</label> <input name="prenom" type="password">
				</div>
				<div class="form-group">
					<button type="submit">Connexion</button>
				</div>
				<%
					if (request.getAttribute("error") != null
							&& (Boolean) request.getAttribute("error")) {
				%>
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> <span class="sr-only">Error:</span> Le
					login ou le mot de passe est invalide.
				</div>
				<%
					}
				%>
			</form>
		</div>

	</div>


</body>
</html>