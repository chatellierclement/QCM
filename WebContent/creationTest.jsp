<%@page import="bo.CategorieBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="content.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Creation d'un QCM</title>
</head>
<body>
	<h1 align="center">Cr�ation d'un Test</h1>
	<br/>
	<div class="col-md-6 col-md-offset-3">
		<form action="creationTest" method="post" align="center">
			<input class="input-sm form-control" type="text" name="libelle" placeholder="Saisissez le nom du test" />
			
			<% List<CategorieBO> lesCategories = ((List<CategorieBO>) request.getAttribute("lesCategories")); %>
			
			<select id="select" name="categorieId">
				<% for(CategorieBO uneCategorie : lesCategories) { %>
  					<option value="<%= uneCategorie.getId()%>"><%= uneCategorie.getLibelle() %></option> 
				<% } %>
			</select>
			
			<input class="input-sm form-control" type="numeric" name="nbQuestion" placeholder="Nombre de question" />
			
			<input class="input-sm form-control" type="numeric" name="duree" placeholder="Duree en min" />
			
			<br/>
			<button type="submit" class="button special">Valider</button>
		</form>
	</div>

<!-- Elements -->
</div>

</section>

</div>
</div>
</body>
</html>