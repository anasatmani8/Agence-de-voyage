<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- META DATA -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!--font-family-->
<link href="https://fonts.googleapis.com/css?family=Rufina:400,700"
	rel="stylesheet" />

<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900"
	rel="stylesheet" />

<!-- TITLE OF SITE -->
<title>Travel</title>

<!-- favicon img -->
<link rel="shortcut icon" type="image/icon"
	href="assets/logo/favicon.png" />


<!--font-awesome.min.css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/font-awesome.min.css" />

<!--animate.css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/animate.css" />

<!--hover.css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/hover-min.css">

<!--datepicker.css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/datepicker.css">

<!--owl.carousel.css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="kiaalap-master/assets/css/owl.theme.default.min.css" />

<!-- range css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/jquery-ui.min.css" />

<!--bootstrap.min.css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/bootstrap.min.css" />

<!-- bootsnav -->
<link rel="stylesheet" href="kiaalap-master/assets/css/bootsnav.css" />

<!--style.css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/style.css" />

<!--responsive.css-->
<link rel="stylesheet" href="kiaalap-master/assets/css/responsive.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>
<body>
	<header class="top-area">
		<div class="header-area">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="logo">
							<a href="index.html"> tour<span>Nest</span>
							</a>
						</div>
						<!-- /.logo-->
					</div>
					<!-- /.col-->
					<div class="col-sm-10">
						<div class="main-menu">

							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle"
									data-toggle="collapse" data-target=".navbar-collapse">
									<i class="fa fa-bars"></i>
								</button>
								<!-- / button-->
							</div>
							<!-- /.navbar-header-->
							<div class="collapse navbar-collapse">
								<ul class="nav navbar-nav navbar-right">
									<li class="smooth-menu"><a href="#home">home</a></li>
									<li class="smooth-menu"><a href="#gallery">Destination</a></li>
									<li ><a href="loginClientt.jsp">Mes Reservations </a></li>
									<li class="smooth-menu"><a href="#spo">Special Offers</a></li>
									<li><a href="Login.jsp">Espace Admin</a></li>
									<li class="smooth-menu"><a href="#subs">subscription</a></li>
									<li>
										<button class="book-btn">book now</button>
									</li>
									<!--/.project-btn-->
								</ul>
							</div>
							<!-- /.navbar-collapse -->
						</div>
						<!-- /.main-menu-->
					</div>
					<!-- /.col-->
				</div>
				<!-- /.row -->
				<div class="home-border"></div>
				<!-- /.home-border-->
			</div>
			<!-- /.container-->
		</div>
		<!-- /.header-area -->

	</header>
	<section id="home" class="about-us">
		<div class="container">
			<div class="about-us-content">
				<div class="row">
					<div class="col-sm-12">
						<div class="single-about-us">
							<div class="about-us-txt">
								<h2>Explore the Beauty of the Beautiful World</h2>
								<div class="about-btn">
									<button class="about-view">explore now</button>
								</div>
								<!--/.about-btn-->
							</div>
							<!--/.about-us-txt-->
						</div>
						<!--/.single-about-us-->
					</div>
					<!--/.col-->
					<div class="col-sm-0">
						<div class="single-about-us"></div>
						<!--/.single-about-us-->
					</div>
					<!--/.col-->
				</div>
				<!--/.row-->
			</div>
			<!--/.about-us-content-->
		</div>
		<!--/.container-->

	</section>
	<div class="container">
		<div class="gallery-details">
			<div class="gallary-header text-center">
				<h2>Voyage Accompagné</h2>
				<p>Liste des voyage disponible .</p>
			</div>
		</div>
	</div>

	<div class="packages-content">
		<div class="row">
		<c:forEach items="${book}" var="e">
			<div class="col-md-4 col-sm-6">
				<div class="single-package-item">
					<img src="data:image/jpg;base64,${e.getBaseImage()}" width="900" height="540" /> 
					<div class="single-package-item-txt">
						<h3>
						<c:out value="${e.getNom_voyage()}" /> <span class="pull-right"> </span>
						</h3>
						<div class="packages-para">
							
						</div>
						<!--/.packages-para-->
						
						<!--/.packages-review-->
						<div class="about-btn" >
							<input class="about-view packages-btn" type="button" onclick="window.location.href ='decouvrirVoyageAcc?idVoyageAcc=<c:out value='${e.getId_voyageAccompagne()}'/>';" value="Book now">
						</div>
						</div>
						</div>
							</div>
						<!--/.about-btn-->
							</c:forEach>
					</div>
				
					
					<!--/.single-package-item-txt-->
				
				</div>
				<!--/.single-package-item-->

		
	<script src="kiaalap-master/assets/js/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->

	<!--modernizr.min.js-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>


	<!--bootstrap.min.js-->
	<script src="kiaalap-master/assets/js/bootstrap.min.js"></script>

	<!-- bootsnav js -->
	<script src="kiaalap-master/assets/js/bootsnav.js"></script>

	<!-- jquery.filterizr.min.js -->
	<script src="kiaalap-master/assets/js/jquery.filterizr.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>

	<!--jquery-ui.min.js-->
	<script src="kiaalap-master/assets/js/jquery-ui.min.js"></script>

	<!-- counter js -->
	<script src="kiaalap-master/assets/js/jquery.counterup.min.js"></script>
	<script src="kiaalap-master/assets/js/waypoints.min.js"></script>

	<!--owl.carousel.js-->
	<script src="kiaalap-master/assets/js/owl.carousel.min.js"></script>

	<!-- jquery.sticky.js -->
	<script src="kiaalap-master/assets/js/jquery.sticky.js"></script>

	<!--datepicker.js-->
	<script src="kiaalap-master/assets/js/datepicker.js"></script>

	<!--Custom JS-->
	<script src="kiaalap-master/assets/js/custom.js"></script>

</body>
</html>