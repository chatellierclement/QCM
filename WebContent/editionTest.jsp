<%@page import="bo.CategorieBO"%>
<%@page import="bo.TestBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../header.jsp" %>
	<title>Edition d'un test</title>
</head>
<body>
<% TestBO unTest = (TestBO) request.getAttribute("unTest"); %>

	<h1 align="center">Edition d'un test <%=unTest.getId()%></h1>
	<br/>
	<div class="col-md-6 col-md-offset-3">
		<form action="editionTest" method="post" align="center">
			<input class="input-sm form-control" type="text" value="<%=unTest.getLibelle() %>" name="libelle" />
			<input type="hidden" value="<%=unTest.getId()%>" name="id">
			<% List<CategorieBO> lesCategories = ((List<CategorieBO>) request.getAttribute("lesCategories")); %>
			
			<select id="select" name="categorieId">
				<% for(CategorieBO uneCategorie : lesCategories) { 
					if(unTest.getId() == uneCategorie.getId()) { %>
						<option selected value="<%= uneCategorie.getId()%>"><%= uneCategorie.getLibelle() %></option> 
					<%} else {%>
	  					<option value="<%= uneCategorie.getId()%>"><%= uneCategorie.getLibelle() %></option> 
					<%} %>
				<% } %>
			</select>
			
			<br/>
			<button type="submit" class="btn btn-primary">Valider</button>
		</form>
	</div>
</body>
</html>