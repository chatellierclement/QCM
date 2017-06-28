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
	List<CandidatBO> listePersonne = ((List<CandidatBO>) request
			.getAttribute("listePersonne"));
%>
<div class="table-wrapper">
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Prenom</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (CandidatBO candidat : listePersonne) {
			%>
			<tr>

				<td><%=candidat.getId()%></td>
				<td><%=candidat.getNom()%></td>
				<td><%=candidat.getPrenom()%></td>
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