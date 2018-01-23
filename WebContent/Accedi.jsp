<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Utente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="it">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.1.1.js"></script>
<LINK rel="stylesheet" href="css/Accedi.css" type="text/css">
<title>Accedi</title>
</head>
<body style="background-color:black">
	<jsp:include page="navBar.jsp"></jsp:include>
	
	<div class="container">
		<div class="row" id="content">
			<form action="AccediServlet" method="get">
				<h1>Accedi</h1>
				<div>
					<input type="text" placeholder="Username" required name="username" id="username" />
				</div>
				<div>
					<input type="password" placeholder="Password" name ="password" required
						id="password" />
				</div>
				<div>
					<input type="submit" value="Log in" /> <a href="Utente_jsp.jsp">Registra</a>
				</div>
			</form>
			<!-- form -->
		</div>
		<!-- content -->
	</div>

	
	
</body>

</body>
</html>