<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%

if (session.getAttribute("clt") == null) {
	
    response.sendRedirect("login.jsp");
    
}
%>
<body>
<%@include file="home_admin.jsp"%>
<div class="edit" style="margin-left:0px; margin-bottom: 300px; "  >
<%@include file="gestionVoyage.jsp"%>
</div>

</body>
</html>