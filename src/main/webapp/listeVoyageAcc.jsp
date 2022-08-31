<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
if (session.getAttribute("clt") == null) {
	System.out.println("test gestion voyage.jsp");
    response.sendRedirect("login.jsp");
    
}
%>
<body>
	<%@include file="home_admin.jsp"%>
	<div class="menutest" style="margin-left: 120px; margin-top: 40px;">
		<div class="container-xl">
			<div class="table-responsive">
				<div class="table-wrapper">
					<div class="table-title">
						<div class="row">
							<div class="col-sm-6">
								<h2>
									Manage <b>Travels</b>
								</h2>

							</div>
							<div class="col-sm-6">
								<a href="afficherAllActiviteVoyage" class="btn btn-success"
									data-toggle="modal"><i class="material-icons">&#xE147;</i>
									<span>Ajouter voyage accompagne</span></a> <a
									href="ReservationAccAdmin" class="btn btn-secondary" data-toggle="modal"><i
									class="material-icons">&#xf23a;</i> <span>Consulter les
										reservations </span></a>

							</div>
						</div>
					</div>
					
					<style>
@media print {
	/* Hide every other element  */
	body *, .modifierEliminer * {
		visibility: hidden;
	}
	/* then displaying print container element */
	.print-container, .print-container * {
		visibility: visible;
	}
	/* Adjusting the position to always start from top left while printing */
	.print-container {
		position: absolute;
		left: 15px;
		top: 0px;
		right: 15px;
	}
	.modifierEliminer * {
		visibility: hidden;
	}
}
</style>
					<label style="margin-left: 10px;">Imprimer tableau :</label>
					<button
						style="margin-left: 13px; padding-right: 71px; padding-left: 69px;"
						onclick="window.print();">Imprimer !</button>


					<div class="row print-container">

						<h2 style="text-decoration: underline; margin-left: 80px;">
							<strong> Tableau des voyages Accompagné: </strong>
						</h2>
						<br> <input type="text" id="mySearch" onkeyup="myFunction()"
							placeholder="Search by destination" title="Type in a category">
						<table id="printTable"
							class="table table-bordered table-striped table-hover dataTable js-exportable">

							<thead>
								<tr>
									<th>id</th>
									<th>nom_voyage</th>
									<th>nom_guide</th>
									<th>activite</th>
								
									<th>destination</th>
									<th>description</th>
									
									<th>image</th>
										<th>Ajouter date</th>
									<th>supprimer</th>
									<th>Modifier</th>
								</tr>
							</thead>
							<tbody id="myMenu">

								<c:forEach items="${hggg}" var="e">
									<tr>
										<td><c:out value="${e.getId_voyageAccompagne()}" /></td>
										<td><c:out value="${e.getNom_voyage()}" /></td>
										<td><c:out value="${e.getNom_guide()}" /></td>
										<td><c:out value="${e.getActivite2()}" /></td>
									
										<td><c:out value="${e.getDestination()}" /></td>
										<td><c:out value="${e.getDescription()}" /></td>
										
										<td><img src="data:image/jpg;base64,${e.getBaseImage()}"
											width="140" height="100" /></td>

<td><a
												href="ajouterDateVoyageAcc.do?idvoyageACC=<c:out value='${e.getId_voyageAccompagne()}'/> "> <i style=" font-size:28px;color:green ;margin-left: 15px;" class="fa fa-calendar" ></i>
											</a></td>
										<td><form action="supprimerVoyageAcc" method="post">
												<input type="hidden" name="idvoyage_Accompagne"
													value="${e.getId_voyageAccompagne()}" /> <input
													style="background-color: red; color: black" type="submit"
													value="Suprimer">

											</form></td>

										<td class="modifierEliminer"><a
											href="modifierVoyageAcc.do?idvoyageAcc=<c:out value='${e.getId_voyageAccompagne()}'/>"><i
												style="margin-left: 30px;" class="material-icons"
												data-toggle="tooltip" title="Edit">&#xE254;</i> </a></td>
									</tr>
									<div></div>
								</c:forEach>
							</tbody>

							<!-- <td>
							<a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
							<a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
						</td> -->

							</tbody>

						</table>
						<b style="margin-left: 400px;" id="date"></b>

					</div>


					<!-- ////////////////////////////////// -->

					<!-- ////////////////////////////////// -->
					<!--    formulaire dajout des etudiants    -->

					<div id="addEmployeeModal" class="modal fade">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="ajoutEt.php" method="post">
									<div class="modal-header">
										<h4 class="modal-title">Add Student</h4>
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label>Nom</label> <input type="text" name="nom"
												class="form-control" required>
										</div>
										<div class="form-group">
											<label>prenom</label> <input type="text" name="prenom"
												class="form-control" required>
										</div>
										<div class="form-group">
											<label>email</label> <input type="email" name="email"
												class="form-control" required>
										</div>
										<div class="form-group">
											<label>sex</label>
											<textarea class="form-control" name="sex" required></textarea>
										</div>

										<div class="form-group">
											<label>role</label> <input type="text" name="role"
												class="form-control" required>
										</div>
										<div class="form-group">
											<label>filiere</label> <input type="text" name="filiere"
												class="form-control" required>
										</div>
										<div class="form-group">
											<label>semestre</label> <input type="text" name="semestre"
												class="form-control" required>
										</div>
									</div>
									<div class="modal-footer">
										<input type="button" class="btn btn-default"
											data-dismiss="modal" value="Cancel"> <input
											type="submit" class="btn btn-success" value="Add">
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- Edit Modal HTML -->

					<!-- Delete Modal HTML -->


				</div>
			</div>
		</div>
	</div>
	<script>
		function myFunction() {
			// Declare variables
			var input, filter, ul, li, a, i;
			input = document.getElementById("mySearch");
			console.log(input.value);
			filter = input.value.toUpperCase();
			ul = document.getElementById("myMenu");
			li = ul.getElementsByTagName("tr");
			// Loop through all list items, and hide those who don't match the search query
			for (i = 0; i < li.length; i++) {
				a = li[i].getElementsByTagName("td")[4];

				if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
					li[i].style.display = "";
				} else {
					li[i].style.display = "none";
				}
			}
		}
	</script>
</body>
</html>