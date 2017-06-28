<%@page import="bo.TestBO"%>
<%@page import="bo.CandidatBO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 	CandidatBO sessio = (CandidatBO) request.getSession().getAttribute("unCandidat"); %>	
<%
	TestBO pTest = ((TestBO) request.getAttribute("unTest"));
%>
	<h1>Bienvenue sur le test   n° <%=pTest.getId() %></h1>

</body>
</html>