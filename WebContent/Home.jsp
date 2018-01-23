<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Utente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head lang="it">
		<title>Gioco_Fantacalcio</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/indexCss.css" type="text/css">
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
	</head>
	<body>
		<jsp:include page="/WEB-INF/pezzi/menu.jsp"></jsp:include>
	  
		<header  align="center" class="row">
			<figure style=" text-align: center" class="col-lg-3">		
				<a href="images/pT.jpg"><img class="img-thumbnails" src="${pageContext.request.contextPath}/images/pT.jpg"  width="300" /></a>
			</figure>
			<hgroup class="col-lg-7">
				<h1>Fantacalcio</h1>
				<h2>&quot;Il vero vincitore di un gioco non &egrave; chi arriva primo ma chi si diverte di pi&ugrave;&quot;</h2>
			</hgroup>
		</header>
		<jsp:include page="/WEB-INF/pezzi/footer-html.jsp"></jsp:include>
	</body>
</html>