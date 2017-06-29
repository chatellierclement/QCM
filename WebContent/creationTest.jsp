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
	<h1 align="center">Création d'un QCM</h1>
	<br/>
	<div class="col-md-6 col-md-offset-3">
		<form action="creationTest" method="post" align="center">
			<input class="input-sm form-control" type="text" name="libelle" placeholder="Saisissez le nom du QCM" />
			
			<% List<CategorieBO> lesCategories = ((List<CategorieBO>) request.getAttribute("lesCategories")); %>
			
			<select id="select" name="categorieId">
				<% for(CategorieBO uneCategorie : lesCategories) { %>
  					<option value="<%= uneCategorie.getId()%>"><%= uneCategorie.getLibelle() %></option> 
				<% } %>
			</select>
			
			<br/>
			<button type="submit" class="btn btn-primary">Valider</button>
		</form>
	</div>

<!-- Elements -->
</div>

</section>

</div>
</div>
</body>
</html>