<%@page import="bo.TestBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choix du test</title>
</head>
<body>
	<h1>Bienvenue XXXX</h1>
	
	<h3>Listes des tests</h3>
	
	<% List<TestBO> listTest = ((List<TestBO>) request.getAttribute("listeTest")) ; %>
	<% if (listTest.size() != 0) { %>
		<% for (TestBO testBO : listTest) { %>
			<%=testBO.getId()%> <%=testBO.getLibelle() %> 
		<% } %>
	<% } else { %>
		Bande de pd, vous avez pas de tests
	<% } %>
</body>
</html>