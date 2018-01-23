<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ page import="model.Utente"%>
<!DOCTYPE html>
<html lang="it">  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gioco_Fantacalcio</title>

<!-- Stiamo dicendo al browser di impostare la larghezza (width) della 
viewport in base alla larghezza dello schermo del dispositivo 
(device-width). La proprietà initial-scale imposta il fattore di zoom 
iniziale, relativo al momento in cui la pagina viene caricata. -->

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- Navigation -->
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">FANTACALCIO</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Info <span class="caret"></span></a>
          <ul class="dropdown-menu">
             <li><a href="TutorialGioco.jsp">TutorialGioco</a></li>
            <li><a href="DoveSiamo.jsp">DoveSiamo</a></li>
          </ul>
        </li>
 </ul>
      
     <%	if(session.getAttribute("utente") == null) { %>
							<ul class="nav navbar-nav navbar-right">
								<li>
									<a href="Utente_jsp.jsp">
										<span class="glyphicon glyphicon-user"></span>
											Registrati
									</a>
								</li>

								<li>
									<a href="Accedi.jsp" >
										<span class="glyphicon glyphicon-log-in"></span>
											Accedi
									</a>
								</li>
							</ul>
					<%} else { %>
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown">
									<a href="#" class="dropdown-toggle"	data-toggle="dropdown">
										<span class="glyphicon glyphicon-user"></span> 
										<%=((Utente)session.getAttribute("utente")).getUsername() %><b class="caret"></b>
									</a>
									<ul class="dropdown-menu">
										<li><a href="utentePanel.jsp" >Profilo</a></li>
										<li><a href="#" id="logout" >Logout</a></li>
									</ul>
								</li>
							</ul>
							<script> 
								$("#logout").click(
										function() {
											window.location.href = "LogoutServlet";
										}
								);
							</script>
					<%} %>
          </div>
          </div>
          </nav>
</body>
</html>