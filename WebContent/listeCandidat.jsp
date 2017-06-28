<%@page import="bo.CandidatBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="content.jsp"%>

<title>Liste des Candidats</title>
<h1>Liste des Candidats :</h1>
<hr class="major" />
<% 	Utilisateur sessionutilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur"); %>	
<%
	List<Utilisateur> lesUtilisateurs = ((List<Utilisateur>) request.getAttribute("lesUtilisateurs"));
%>
<div class="table-wrapper">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Type</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Utilisateur utilisateur : lesUtilisateurs) {
			%>
			<tr>

				<td><%=utilisateur.getId()%></td>
				<td><%=utilisateur.getNom()%></td>
				<td><%=utilisateur.getPrenom()%></td>
				<td><%=utilisateur.getType() %>
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