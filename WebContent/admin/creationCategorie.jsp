<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../header.jsp" %>
	<title>Creation d'une cat�gorie</title>
</head>
<body>
	<h1 align="center">Cr�ation d'une cat�gorie</h1>
	<br/>
	<div class="col-md-6 col-md-offset-3">
		<form action="creationCategorie" method="post" align="center">
			
			<input class="input-sm form-control" type="text" name="categorie" placeholder="Saisissez une cat�gorie" />
			<br/>
			<button class="btn btn-primary">Valider</button>
		</form>
	</div>
</body>
</html>