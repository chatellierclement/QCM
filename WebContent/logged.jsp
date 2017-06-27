<%@page import="bo.CandidatBO"%>
<%@page import="bo.TestBO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="content.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choix du test</title>
</head>
<body>
<% 	CandidatBO sessio = (CandidatBO) request.getSession().getAttribute("unCandidat"); %>	

	<h1>Bienvenue <%= sessio.getPrenom() %> <%= sessio.getNom() %> </h1>
	<hr class="major" />
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

<!-- Elements -->
</div>

</section>

</div>
</div>