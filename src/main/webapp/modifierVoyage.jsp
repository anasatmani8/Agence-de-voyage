<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="home_admin.jsp"%>
<div class="edit" style="margin-left:300px; "  >
<div class="container">
  <h2 style="margin-top:200px;">Modifier Voyage</h2>
  <form action="modifierVoyage" method="post" >
    <div class="form-group" >
      <label >id Voyage:</label>
      <input type="text" class="form-control" name="id" value="${e.id_voyage}" readonly="readonly">
    </div>
    
     <div class="form-group">
      <label for="pwd">Nom ville</label>
      <input type="text" class="form-control" name="nom_ville"value="${e.getNom_ville()}"readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="pwd">Nom Hotel</label> <br>
       <select name="nom_hotel">
									<c:forEach items="${model.hotels}" var="p">
										<option>${p.getNom_hotel()}</option>
									</c:forEach>
								</select>
    </div>
    
    <div class="form-group">
      <label for="pwd">prix</label> 
      
      <input type="text" class="form-control" name="prix"value="${e.getPrix_hotel()}">
    </div>
    
     <div class="form-group">
      <label for="pwd">Date depart</label> <br>
      <input type="date"  name="date_depart"value="${e.getDate_depart()}">
    </div>
    
     <div class="form-group">
      <label for="pwd">Date fin</label><br>
      <input type="date"name="date_fin"value="${e.getDate_fin()}">
    </div>
    
     <div class="form-group">
      <label for="pwd">description</label>
      <input type="text" class="form-control" name="description"value="${e.getDescription_hotel()}">
    </div>
    <div>
    	<button type="submit" class="btn btn-primary">Modifier</button>
    </div>
  </form>
</div>
</div>

</body>
</html>