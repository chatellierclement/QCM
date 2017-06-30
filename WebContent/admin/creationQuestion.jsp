<%@page import="bo.CategorieBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../content.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Creation d'une question</title>
</head>
<body>
	<h1 align="center">Création d'une question</h1>
	<br/>
	<div class="col-md-8 col-md-offset-2">
		<form action="creationQuestion" method="post" align="center">
			
			<div class="col-md-3">
				<label>Catégorie :</label>
			</div>
			<div class="col-md-9">
				<% List<CategorieBO> listeCategorie = ((List<CategorieBO>) request.getAttribute("listeCategorie")); %>
				<select class="form-control" name="categorie">
					<% for (CategorieBO categorie : listeCategorie) { %>
					<option value="<%= categorie.getId() %>"><%= categorie.getLibelle() %></option>
					<% } %>
				</select>
			</div>
		
			<textarea class="input-sm form-control" name="question" placeholder="Saisissez la question"></textarea>
	
			<div class="panel panel-default">
				<div class="panel-heading">
				    <h3 class="panel-title">Réponse(s)</h3>
		  		</div>
				<div class="panel-body">
					<div class="col-md-10">
						<input class="input-sm form-control" type="text" name="rep" placeholder="Saisissez une réponse à la question" />
					</div>
			   	 	<div class="col-md-2">
			   	 		<a href="#" id="btnAjout" class="button special">+</a>	
			  		</div>
			  	</div>
			</div>
			
			<table class="tabReponse">
				<thead>
					<tr>
						<td width="65%">Réponse</td>
						<td width="25%">Etat</td>
						<td width="10%">Supprimer</td>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			
			<div id="reponses">
			
			</div>
			
			<br/>
			
			<a href="#" id="btnValide" class="button special">Valider</a>
		</form>
	</div>
	<script>
		var nbReponse = 1;
		$("#btnAjout").click(function() {
			var question = $("textarea[name='question']").val() ;
			var reponse = $("input[name='rep']").val() ;
			
			if(question.trim().length <= 0) {
				alert("Veuillez saisir une question avant de saisir les réponses !") ;
				return;
			}

			if(reponse.trim().length > 0) {
				$("tbody").append("<tr><td>" + reponse + "</td><td><select class='choixEtat'><option value='0'>Mauvaise Réponse</option><option value='1'>Bonne Réponse</option></select></td><td><button class='supprimerRep btn-sm'>X</button></td><input type='hidden' name='reponse' value='" + reponse + "' /><input type='hidden' name='etat' value='0' /></tr>") ;
				
				nbReponse++;
				$("input[name='rep']").val("") ;
			}
			else {
				alert("Veuillez saisir une réponse avant de valider !") ;
			}
			
		}) ;
		
		$("#btnValide").click(function() {
			$("form").submit();
		}) ;
		
		$(".tabReponse").on('click', '.supprimerRep', function () {
			$(this).closest('tr').remove();
		}) ;
		
		$(document).on('change', 'select.choixEtat', function() {
			$(this).closest('tr').find("input[name='etat']").val(this.value) ;
		}) ;
	</script>
</body>
</html>