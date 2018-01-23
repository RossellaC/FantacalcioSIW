<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="model.Invito" %>
<%@ page import="model.Utente"%>
<jsp:useBean id="lega" scope="request" type="model.Lega"></jsp:useBean>
<jsp:useBean id="inviti" scope="request" type="List<Invito>"></jsp:useBean>

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
		<h1>Invita utente</h1>      
		<p>Invita un altro utente a far parte di questa lega.</p>
	</div>
	<div class="container">
		<h5>Inviti</h5>
		<%
			if(inviti.size() > 0) {
		%>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Email</th>
			      <th scope="col">Stato</th>
			    </tr>
			  </thead>
			  <tbody>
		<%
				for(Invito l : inviti) {
		%>
				<tr>
					<td><%= l.getFkUtenteRiceve() %></td>
					<td><%= l.isAccettazione() ? "Accettato" : "Non Accettato" %></td>
			    </tr>
		<%
				}
		%>
			</tbody>
			</table>
			</div>
		<%
			} else {
		%>
			<p>Non hai invitato nessuno per questa lega.</p>
		<%
			}
		%>
		<br>
		<form action="${pageContext.request.contextPath}/invitaUtente" method="POST">
			<div class="form-group">
				<label for="nomeLega1">Nome</label>
				<input value="" name="nome" type="text" class="form-control" id="nomeLega1" placeholder="Nome utente da invitare">
			</div>
			<input type="hidden" name="lega" value="<%= lega.getId() %>" >
			<button type="submit" class="btn btn-primary">Invia</button>
		</form>
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