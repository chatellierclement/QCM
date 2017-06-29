<%@page import="bo.Utilisateur"%>
<%@page import="bo.TestBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@include file="content.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choix du test</title>
</head>
<body>
	<% 	Utilisateur sessionUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur"); %>	

	<h1>Bienvenue <%= sessionUtilisateur.getPrenom() %> <%= sessionUtilisateur.getNom() %> </h1>
	<hr class="major" />
	
	<% if("Admin".equals(sessionUtilisateur.getType())) { %>
		<a href="<%=request.getContextPath()%>/creationTest">Création d'un test</a> &nbsp
		<a href="<%=request.getContextPath()%>/creationQuestion">Création des questions</a>
	<% } %>
	<hr class="major" />
	<h3>Listes des tests</h3>
	
	<% List<TestBO> listTest = ((List<TestBO>) request.getAttribute("listeTest")) ; %>

<div class="table-wrapper">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Libelle</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (TestBO test : listTest) {
			%>
			<tr>
				<td><%=test.getId()%></td>
				<td><%=test.getLibelle()%></td>
				<td>
					<a href="<%=request.getContextPath()%>/test?id=<%=test.getId()%>">Lancer le test</a>
					<% if("Admin".equals(sessionUtilisateur.getType())) { %>
					&nbsp
					<a href="<%=request.getContextPath()%>/suppressionTest?id=<%=test.getId()%>">Suprimer le test</a>
					&nbsp
					<a href="<%=request.getContextPath()%>/editionTest?id=<%=test.getId()%>">Editer le test</a>
					<% } %>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>

<!-- Elements -->
</div>

</section>

</div>
</div>
</body>
</html>