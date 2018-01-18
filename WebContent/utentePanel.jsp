<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Utente"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>UtentePanel</title>

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
		if (request.getAttribute("utente") != null) {
	%>
	<jsp:include page="navBar.jsp"></jsp:include>
	  <div class="jumbotron">
    <h1>Benvenuto</h1>      
    <p>Inizia a giocare</p>
  </div>
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li class="sidebar-brand"><a> ListaCalciatori </a></li>
			<li><a href="#">Crae una Rosa</a></li>
			
		</ul>
	
	<!-- /#sidebar-wrapper -->
	<%
		} else {
	%>

		<jsp:include page="ErrorePag.jsp"></jsp:include>
</div>
	<%
		}
	%>

</body>

</html>