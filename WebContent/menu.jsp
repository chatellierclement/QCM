<%@page import="bo.Utilisateur"%>

<%
	Utilisateur sessionUtilisateur2 = (Utilisateur) request.getSession().getAttribute("utilisateur");
%>	
<!-- Menu -->
<nav id="menu">
	<header class="major">
		<h2>Menu</h2>
	</header>
	<ul>
		<li><a href="<%=request.getContextPath()%>/logged">Accueil</a></li>
		<li><a href="<%=request.getContextPath()%>/listeCandidat">Liste des Candidats</a></li>
		
		<% if("Admin".equals(sessionUtilisateur2.getType())) { %>
				<li><a href="<%=request.getContextPath()%>/creationTest">Création d'un test</a></li>
				<li><a href="<%=request.getContextPath()%>/creationQuestion">Création d'une question</a></li>
				<li><a href="<%=request.getContextPath()%>/creationCategorie">Création d'une catégorie</a></li>
				<li><a href="<%=request.getContextPath()%>/listeQuestion">Liste des questions</a></li>
		<% } %>
		<li><a href="<%=request.getContextPath()%>/deconnect">Déconnexion</a></li>
	</ul>
</nav>