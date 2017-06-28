<%@page import="bo.QuestionBO"%>
<%@page import="java.util.List"%>
<%@page import="bo.CandidatBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="content.jsp"%>
<title>Insert title here</title>
</head>
<body>
<% 	CandidatBO sessio = (CandidatBO) request.getSession().getAttribute("unCandidat"); %>	
<%
	List<QuestionBO> pTest = ((List<QuestionBO>) request.getAttribute("unTest"));
%>
	<h1>Bienvenue sur le test Monsieur <%=sessio.getNom() %> - <%=sessio.getPrenom() %></h1>

<div class="table-wrapper">
	<table>
		<thead>
			<tr>
				<th>Catégorie</th>
				<th>Numéro Question</th>
				<th>Libelle de la question</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (QuestionBO test : pTest) {
			%>
			<tr>
				<td><%=test.getCategorie().getLibelle()%></td>
				<td><%=test.getId()%></td>
				<td><%=test.getLibelle()%></td>
<%-- 				<td><a href="<%=request.getContextPath()%>/test?id=<%=test.getId()%>">Lancer le test</a>
 --%>				<td><a href="<%=request.getContextPath()%>/question?id=<%=test.getId() %>" class="button special">Répondre</a></td>
				
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