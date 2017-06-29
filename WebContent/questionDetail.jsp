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

<form action="" method="post">
	<div class="table-wrapper">
		<table>
			<thead>
				<tr>
					<th><%=pQuestion.get(0).getLibelle()%></th>
				</tr>
			</thead>
			<tbody>
				<%
					String id = "demo-priority-low";
					for (int i = 0; i< pReponse.size(); i++) {			
						if (i == 1) {
							id = "demo-priority-normal";
						} else if (i == 2) {
							id = "demo-priority-high";
						}
				%>			
				<tr>
	
					<td><%=pReponse.get(i).getLibelle()%></td>
					<td>
						<div class="4u 12u$(small)">
							<input id="<%= id %>" type="radio" name="demo-priority" value="<%=pReponse.get(i).getId() %>" />
							<label for="<%= id %>"></label>
						</div>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<center><input class="button default" type="submit" value="Envoyer la réponse" /></center>	
</form>

<!-- Elements -->
</div>

</section>

</div>
</div>
</body>
</html>