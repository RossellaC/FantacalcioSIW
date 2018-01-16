<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Utente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head lang="it">
	<title>Gioco_Fantacalcio</title>
	<meta charset="utf-8" />
	<style type="text/css">
 body {
    height: 100%;
    margin: 0;
    background-image: url("images/palla.jpg");

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
	</style>
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<LINK rel="stylesheet" href="css/indexCss.css" type="text/css">
	</head>

<body>
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
       <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
        <a  href="Utente_jsp.jsp"><span class="glyphicon glyphicon-user"> </span> Registrati</a>
        
          </li>
          
        <li><a href="Accedi.jsp"><span class="glyphicon glyphicon-log-in"></span> Accedi</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<header  align="center" class="row">

	<figure style=" text-align: center" class="col-lg-3">		
	<a href="images/pT.jpg"><img class="img-thumbnail" src="images/pT.jpg"  width="300" /></a>
	</figure>
	<hgroup class="col-lg-7">
	<h1>Fantacalcio</h1>
	<h2>&quot;Il vero vincitore di un gioco non &egrave; chi arriva primo ma chi si diverte di pi&ugrave;&quot;</h2>
	</hgroup>	
	
</header>


</body>
</html>