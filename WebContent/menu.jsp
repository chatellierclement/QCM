<%@page import="bo.Utilisateur"%>

<% 	Utilisateur sessionUtilisateur2 = (Utilisateur) request.getSession().getAttribute("utilisateur"); %>	
<!-- Menu -->
<nav id="menu">
	<header class="major">
		<h2>Menu</h2>
	</header>
	<ul>
		<li><a href="<%=request.getContextPath()%>/deconnect">Déconnexion</a></li>
		<li><a href="<%=request.getContextPath()%>/listeCandidat">Liste des Candidats</a></li>
		
		<% if("Admin".equals(sessionUtilisateur2.getType())) { %>
				<li><a href="surprise.jsp">Création d'un test</a></li>
		<% } %>

	</ul>
</nav>