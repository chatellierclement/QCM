<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../header.jsp" %>
	<title>Creation d'un QCM</title>
</head>
<body>
	<h1 align="center">Cr�ation d'une question</h1>
	<br/>
	<div class="col-md-6 col-md-offset-3">
		<form action="creationQuestion" method="post" align="center">
			<select name="categorie">
				<option>Categorie</option>
			</select>
		
			<textarea class="input-sm form-control" name="question" placeholder="Saisissez la question"></textarea>
	
			<div class="panel panel-default">
				<div class="panel-heading">
				    <h3 class="panel-title">R�ponse(s)</h3>
		  		</div>
				<div class="panel-body">
					<div class="col-md-10">
						<input class="input-sm form-control" type="text" name="rep" placeholder="Saisissez une r�ponse � la question" />
					</div>
			   	 	<div class="col-md-2">
			  			<button id="btnAjout" type="button" class="btn btn-primary btn-sm">+</button>
			  		</div>
			  	</div>
			</div>
			
			<div id="reponses">
			
			</div>
			
			<br/>
			<button class="btn btn-primary">Valider</button>
		</form>
	</div>
	<script>
		var nbReponse = 1;
		$("#btnAjout").click(function() {
			var question = $("textarea[name='question']").val() ;
			var reponse = $("input[name='rep']").val() ;
			
			if(question.trim().length <= 0) {
				alert("Veuillez saisir une question avant de saisir les r�ponses !") ;
				return;
			}

			if(reponse.trim().length > 0) {
				$("#reponses").append("<p>" + nbReponse + ". " + reponse + "</p>") ;
				nbReponse++;
				$("input[name='rep']").val("") ;
				$("#reponses").append("<input type='hidden' name='reponse' value='" + reponse + "' />");
			}
			else {
				alert("Veuillez saisir une r�ponse avant de valider !") ;
			}
			
		}) ;
	</script>
</body>
</html>