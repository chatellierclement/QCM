<%@page import="bo.CandidatBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Candidats :</title>
</head>
<body>
<h1>Liste des Candidats :</h1>

	
    <% List<CandidatBO> listePersonne = ((List<CandidatBO>) request.getAttribute("listePersonne")) ; %>
	<% if (listePersonne.size() != 0) { %>
		<% for (CandidatBO candidat : listePersonne) { %>
			<%=candidat.getId()%> <%=candidat.getNom() %> 
			<%=candidat.getPrenom() %>
		<% } %>
	<% } else { %>
		Pas de candidats
	<% } %>

</body>
</html>