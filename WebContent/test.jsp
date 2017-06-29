<%@page import="bo.QuestionBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="content.jsp"%>
<title>Insert title here</title>
</head>
<body>
<%
	Utilisateur sessionUtilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
%>	
<%
	List<QuestionBO> pTest = ((List<QuestionBO>) request.getAttribute("unTest"));
%>
	<h1>Bienvenue sur le test <%=sessionUtilisateur.getNom() %> - <%=sessionUtilisateur.getPrenom() %></h1>

<div class="table-wrapper">
	<table>
		<thead>
			<tr>
				<th>Catégorie</th>
				<th>Numéro Question</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(int i =0; i < pTest.size(); i++){
			%>
			<tr>
				<td><%=pTest.get(i).getCategorie().getLibelle()%></td>
				<td>Question : <%=i+1 %></td>
					<% List<Integer> verifReponse = ((List<Integer>) request.getAttribute("verifReponse")); %>
					<% boolean bool = false; 
						String button = "Repondre";
						String couleur = "special";
					for (Integer value : verifReponse) {
						if (value.equals(pTest.get(i).getId())) { 
							bool = true;
							button = "Modifier";
							couleur = "default";
						 } 
					 } 
					%>
					<td><a href="<%=request.getContextPath()%>/question?idTest=<%=request.getAttribute("idTest")%>&id=<%=pTest.get(i).getId() %>" class="button <%= couleur %>"><%= button %></a></td>
					
					
					<%	if (bool) { %>
							<td><i class="fa fa-check-square-o" aria-hidden="true"></i></td>	
						<% } else { %>
							<td></td>
					 <% } %>
					
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