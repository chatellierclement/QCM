<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../header.jsp" %>
	<title>Creation d'un QCM</title>
</head>
<body>
	<h1 align="center">Création d'un QCM</h1>
	<br/>
	<div class="col-md-6 col-md-offset-3">
		<form action="creationQCM" method="post" align="center">
			<input class="input-sm form-control" type="text" name="nom" placeholder="Saisissez le nom du QCM" />
			
			<div class="panel panel-default">
				<div class="panel-heading">
				    <h3 class="panel-title">Question(s)</h3>
		  		</div>
				<div class="panel-body">
					<div class="col-md-10">
						<input class="input-sm form-control" type="text" name="question" placeholder="Saisissez une question à ajouter au QCM" />
					</div>
			   	 	<div class="col-md-2">
			  			<button class="btn btn-primary btn-sm">+</button>
			  		</div>
			  	</div>
			</div>
			
			<br/>
			<button class="btn btn-primary">Valider</button>
		</form>
	</div>
</body>
</html>