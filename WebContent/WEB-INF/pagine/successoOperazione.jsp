<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Complimenti</title>
</head>
<body>
	<%
		if (request.getSession().getAttribute("utente") != null) {
	%>
	<div class="container" id="sidebar-wrapper">
		<jsp:include page="/WEB-INF/pezzi/navBar.jsp"></jsp:include>
		<h2>Complimenti</h2>
		<p>
			Operazione eseguita con successo!
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/pannelloUtente">Torna all'area personale</a>
		</p>
	<%
		} else {
	%>
		<jsp:include page="/ErrorePag.jsp"></jsp:include>
	<%
		}
	%>
	</div>
</body>
</html>