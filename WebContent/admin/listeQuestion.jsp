<%@page import="bo.QuestionBO"%>
<%@page import="bo.CategorieBO"%>
<%@page import="java.util.List"%>
<%@include file="../content.jsp"%>

<title>Liste des questions</title>
<h1>Liste des questions :</h1>
<hr class="major" />
<% Utilisateur sessionutilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur"); %>
<% List<QuestionBO> listeQuestion = (List<QuestionBO>) request.getAttribute("listeQuestion") ; %>
<% List<CategorieBO> listeCategorie = (List<CategorieBO>) request.getAttribute("listeCategorie") ; %>

<div class="col-md-12">
	<% for (CategorieBO categorie : listeCategorie) { %>
	<div class="panel panel-primary">
      	<div class="panel-heading"><%= categorie.getLibelle() %></div>
      	<div class="panel-body">
      		<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Libelle</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
				</thead>
				<tbody>
				<% for(QuestionBO question : listeQuestion) { %>
					<% if(categorie.getId() == question.getCategorie().getId()) { %>
					<tr>
						<td><%= question.getId() %></td>
						<td><%= question.getLibelle() %></td>
						<td><a href="#">Editer</a></td>
						<td><a href="supprimerQuestion?id=<%= question.getId() %>">Supprimer</a></td>
					</tr>
					<% } %>
				<% } %>
				</tbody>
			</table>
		</div>
    </div>
	<% } %>
</div>

</body>
</html>