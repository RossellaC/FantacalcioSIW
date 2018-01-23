<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Utente"%>
<%@ page import="model.Lega"%>
<%@ page import="model.Squadra"%>
<jsp:useBean id="lega" scope="request" type="model.Lega"></jsp:useBean>
<jsp:useBean id="squadre" scope="request" type="List<Squadra>"></jsp:useBean>

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
		<h1>Dettagli Lega</h1>      
		<p>Inizia a giocare</p>
	</div>
	<div class="container">
		<form action="${pageContext.request.contextPath}/creaLega" method="POST">
			<div class="form-group">
				<label for="nomeLega1">Nome</label>
				<input value="<%= lega.getNome() %>" name="nome" type="text" class="form-control" id="nomeLega1" placeholder="Nome nuova lega">
			</div>
			<div class="form-group">
				<label for="descrizioneLega1">Descrizione</label>
				<textarea name="descrizione" class="form-control" id="descrizioneLega1" rows="5"><%= lega.getDescrizione() %></textarea>
			</div>
			<div class="form-group">
				<label for="budgetLega1">Budget Iniziale</label>
				<input value="<%= lega.getBudgetIniziale() %>" name="budget" type="text" class="form-control" id="budgetLega1" placeholder="Budget iniziale">
			</div>
			<button type="submit" class="btn btn-primary">Aggiorna</button>
		</form>
		<br>
		<h5>Squadre</h5>
		<%
			if(squadre.size() > 0) {
		%>
			<div class="list-group">
		<%
				for(Squadra l : squadre) {
		%>
				<a href="#" class="list-group-item list-group-item-action"><%= l.getNome() %></a>
		<%
				}
		%>
			</div>
		<%
			} else {
		%>
			<p>Non ci sono squadre per questa lega.</p>
		<%
			}
		%>
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a href="${pageContext.request.contextPath}/invitaUtente?id=<%= lega.getId() %>">Invita utente</a></li>
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