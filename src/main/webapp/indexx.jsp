<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<body>
<div align="center">
    <h2><c:out value="${book.nom_voyage}" /></h2>
    <h3><c:out value="${book.prix}" /></h3>
    <img src="data:image/jpg;base64,${book.baseImage}" width="140" height="100"/>
</div>
</body>
</html>