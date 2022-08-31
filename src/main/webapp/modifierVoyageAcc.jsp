<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon"
	href="kiaalap-master/img/favicon.ico">
<!-- Google Fonts
		============================================ -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900"
	rel="stylesheet">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/bootstrap.min.css">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/font-awesome.min.css">
<!-- owl.carousel CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/owl.carousel.css">
<link rel="stylesheet" href="kiaalap-master/css/owl.theme.css">
<link rel="stylesheet" href="kiaalap-master/css/owl.transitions.css">
<!-- animate CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/animate.css">
<!-- normalize CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/normalize.css">
<!-- meanmenu icon CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/meanmenu.min.css">
<!-- main CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/main.css">
<!-- educate icon CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/educate-custon-icon.css">
<!-- morrisjs CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/morrisjs/morris.css">
<!-- mCustomScrollbar CSS
		============================================ -->
<link rel="stylesheet"
	href="kiaalap-master/css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- metisMenu CSS
		============================================ -->
<link rel="stylesheet"
	href="kiaalap-master/css/metisMenu/metisMenu.min.css">
<link rel="stylesheet"
	href="kiaalap-master/css/metisMenu/metisMenu-vertical.css">
<!-- calendar CSS
		============================================ -->
<link rel="stylesheet"
	href="kiaalap-master/css/calendar/fullcalendar.min.css">
<link rel="stylesheet"
	href="kiaalap-master/css/calendar/fullcalendar.print.min.css">
<!-- forms CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/form/all-type-forms.css">
<!-- dropzone CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/dropzone/dropzone.css">
<!-- style CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/style.css">
<!-- responsive CSS
		============================================ -->
<link rel="stylesheet" href="kiaalap-master/css/responsive.css">
<!-- modernizr JS
		============================================ -->
<script src="kiaalap-master/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
	<%@include file="home_admin.jsp"%>
	<div class="row" style="margin-left: 200px; margin-top: 100px;">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<div class="review-content-section">
				<div id="dropzone1" class="pro-ad">
					<form action="modifierVoyageAcc" method="post"
						enctype="multipart/form-data">
						<div class="row">

							<h2 style="color: green; margin-left: 50px; margin-bottom: 30px;"
								class="modal-title">Modifier Voyage accompagne</h2>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label for=""> <strong>id Voyage accompagné:</strong></label> <input
										type="text" class="form-control" name="id"
										value="${e.getId_voyageAccompagne()}" readonly="readonly">
								</div>
								<div class="form-group">
									<label for="pwd"><strong>Nom voyage</strong> </label> <input
										type="text" class="form-control" name="nom_voyage"
										value="${e.getNom_voyage()}" readonly="readonly">
								</div>
								<div class="form-group">
									<label for="pwd"><strong>Nom guide</strong></label> <input
										type="text" class="form-control" name="nom_guide"
										value="${e.getNom_guide()}">
								</div>
								<div class="form-group">
									<label for="pwd"><strong>date_depart</strong></label> <input
										type="text" class="form-control" name="date_depart"
										value="${e.getDate_depart()}">
								</div>
								<div class="form-group">
									<label for="pwd"><strong>destination</strong></label> <input
										type="text" class="form-control" name="destination"
										value="${e.getDestination()}">
								</div>
								<div class="form-group alert-up-pd">
									<label for="pwd"><strong>description</strong></label> <input
										type="text" class="form-control" name="description"
										value="${e.getDescription()}">
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label for="pwd"><strong>Activite</strong></label> <br> <select name="activite">
										<c:forEach items="${model}" var="e">
											<option>${e.getNom_activite()}</option>
										</c:forEach>
									</select>	
								</div>
								<div class="form-group res-mg-t-15">
									<label for="pwd"><strong>durée</strong></label> <input
										type="text" class="form-control" name="dure"
										value="${e.getDuree()}">
								</div>
								<div class="form-group">
									<label for="pwd"><strong>prix</strong></label> <input
										type="text" class="form-control" name="prix"
										value="${e.getPrix()}">
								</div>


							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<div class="payment-adress">
									<button style="margin-Left: 20px;" type="submit"
										class="btn btn-primary waves-effect waves-light">Submit</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="kiaalap-master/js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script src="kiaalap-master/js/bootstrap.min.js"></script>
	<!-- wow JS
		============================================ -->
	<script src="kiaalap-master/js/wow.min.js"></script>
	<!-- price-slider JS
		============================================ -->
	<script src="kiaalap-master/js/jquery-price-slider.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script src="kiaalap-master/js/jquery.meanmenu.js"></script>
	<!-- owl.carousel JS
		============================================ -->
	<script src="kiaalap-master/js/owl.carousel.min.js"></script>
	<!-- sticky JS
		============================================ -->
	<script src="kiaalap-master/js/jquery.sticky.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script src="kiaalap-master/js/jquery.scrollUp.min.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script
		src="kiaalap-master/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="kiaalap-master/js/scrollbar/mCustomScrollbar-active.js"></script>
	<!-- metisMenu JS
		============================================ -->
	<script src="kiaalap-master/js/metisMenu/metisMenu.min.js"></script>
	<script src="kiaalap-master/js/metisMenu/metisMenu-active.js"></script>
	<!-- morrisjs JS
		============================================ -->
	<script src="kiaalap-master/js/sparkline/jquery.sparkline.min.js"></script>
	<script src="kiaalap-master/js/sparkline/jquery.charts-sparkline.js"></script>
	<!-- calendar JS
		============================================ -->
	<script src="kiaalap-master/js/calendar/moment.min.js"></script>
	<script src="kiaalap-master/js/calendar/fullcalendar.min.js"></script>
	<script src="kiaalap-master/js/calendar/fullcalendar-active.js"></script>
	<!-- maskedinput JS
		============================================ -->
	<script src="kiaalap-master/js/jquery.maskedinput.min.js"></script>
	<script src="kiaalap-master/js/masking-active.js"></script>
	<!-- datepicker JS
		============================================ -->
	<script src="kiaalap-master/js/datepicker/jquery-ui.min.js"></script>
	<script src="kiaalap-master/js/datepicker/datepicker-active.js"></script>
	<!-- form validate JS
		============================================ -->
	<script src="kiaalap-master/js/form-validation/jquery.form.min.js"></script>
	<script src="kiaalap-master/js/form-validation/jquery.validate.min.js"></script>
	<script src="kiaalap-master/js/form-validation/form-active.js"></script>
	<!-- dropzone JS
		============================================ -->
	<script src="kiaalap-master/js/dropzone/dropzone.js"></script>
	<!-- tab JS
		============================================ -->
	<script src="kiaalap-master/js/tab.js"></script>
	<!-- plugins JS
		============================================ -->
	<script src="kiaalap-master/js/plugins.js"></script>
	<!-- main JS
		============================================ -->
	<script src="kiaalap-master/js/main.js"></script>
	<!-- tawk chat JS
		============================================ -->
	<script src="kiaalap-master/js/tawk-chat.js"></script>

</body>
</html>