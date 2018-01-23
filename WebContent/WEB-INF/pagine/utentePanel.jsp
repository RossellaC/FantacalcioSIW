<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Utente"%>
<%@ page import="model.Lega"%>
<jsp:useBean id="leghe" scope="request" type="List<Lega>" />
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Pannello di controllo</title>

<!-- Bootstrap Core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">


</head>

<body>
   
	<%
		if (request.getSession().getAttribute("utente") != null) {
	%>
	<jsp:include page="/WEB-INF/pezzi/navBar.jsp"></jsp:include>
	<div class="jumbotron">
		<h1>Benvenuto</h1>      
		<p>Inizia a giocare</p>
	</div>
	<div id="sidebar-wrapper">
		<h5>Le mie leghe</h5>
		<%
			if(leghe.size() > 0) {
		%>
			<div class="list-group">
		<%
				for(Lega l : leghe) {
		%>
				<a href="${pageContext.request.contextPath}/dettagliLega?id=<%= l.getId() %>" class="list-group-item list-group-item-action"><%= l.getNome() %></a>
		<%
				}
		%>
			</div>
		<%
			} else {
		%>
			<p>Non hai accesso a nessuna lega.</p>
		<%
			}
		%>
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="${pageContext.request.contextPath}/creaLega">Crea una Lega</a></li>
			<li class="sidebar-brand"><a> ListaCalciatori </a></li>
			<li><a href="#">Crae una Rosa</a></li>
		</ul>
	
	</div>
	<!-- /#sidebar-wrapper -->
	<%
		} else {
	%>

		<jsp:include page="/ErrorePag.jsp"></jsp:include>
	<%
		}
	%>

</body>

</html>