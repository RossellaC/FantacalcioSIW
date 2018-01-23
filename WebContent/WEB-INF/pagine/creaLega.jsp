<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crea nuova lega</title>
</head>
<body>
	<%
		if (request.getSession().getAttribute("utente") != null) {
	%>
	<div class="container" id="sidebar-wrapper">
		<jsp:include page="/WEB-INF/pezzi/navBar.jsp"></jsp:include>
		<div class="jumbotron">
			<h1>Creazione Lega</h1>
		</div>
		<form action="${pageContext.request.contextPath}/creaLega" method="POST">
			<div class="form-group">
				<label for="nomeLega1">Nome</label>
				<input name="nome" type="text" class="form-control" id="nomeLega1" placeholder="Nome nuova lega">
			</div>
			<div class="form-group">
				<label for="descrizioneLega1">Descrizione</label>
				<textarea name="descrizione" class="form-control" id="descrizioneLega1" rows="5"></textarea>
			</div>
			<div class="form-group">
				<label for="budgetLega1">Budget Iniziale</label>
				<input name="budget" type="text" class="form-control" id="budgetLega1" placeholder="Budget iniziale">
			</div>
			<button type="submit" class="btn btn-primary">Salva</button>
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