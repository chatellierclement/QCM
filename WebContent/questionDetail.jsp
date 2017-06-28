<%@page import="bo.ReponseBO"%>
<%@page import="bo.QuestionBO"%>
 <%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="content.jsp"%>
<%
	List<ReponseBO> pReponse = ((List<ReponseBO>) request
			.getAttribute("pReponse"));
%>
<%
	List<QuestionBO> pQuestion = ((List<QuestionBO>) request.getAttribute("pQuestion"));
%>


<title>Liste des Réponses</title>
<h1>Question : <%= pReponse.get(0).getQuestion().getId() %></h1>
<hr class="major" />
<% 	Utilisateur sessionUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur"); %>	

<div class="table-wrapper">
	<table>
		<thead>
			<tr>
				<th><%=pQuestion.get(0).getLibelle()%></th>
			</tr>
		</thead>
		<tbody>
			<%
				for (ReponseBO reponse : pReponse) {
			%>
			<tr>

				<td><%=reponse.getLibelle()%></td>
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