
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>All Courses | Kiaalap - Kiaalap Admin Template</title>
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
<style type="text/css">
..wrapper{width:100%;}
.box{float:left; height:100px; font-size:40px;}
.box:nth-child(1){
   width:50%;background-color:none; 
}
.box:nth-child(2){
  width:50%;background-color:none; 
}


</style>
</head>

<body>

	<!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
	<!-- Start Left menu area -->
	
		<div class="courses-area">
			<div class="container-fluid">
				<div id="myMenu" class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<c:forEach items="${book}" var="e">
							<div style=" box-shadow: 6px 6px 6px 6px #94b8bf;" id="tr" class="courses-inner res-mg-b-30">
								<div id="td" class="courses-title">
								<h2 style=" color: green; font-size: 40px ;text-align: center ; text-decoration: bold; ">
										<c:out value="${e.getNom_voyage()}" />
									</h2>
									<a href="#">
									
									<img
										src="data:image/jpg;base64,${e.getBaseImage()}" width="1300"
										height="1500" /></a>
									
								</div>
								<div  id="td" class="courses-alaltic">
									<a style="font-size: 30px;">
											
											 <c:out value="${e.getPrix() }" /></a> 
											 <span style="font-size: 30px;" class="course-icon"><i
											class="fa fa-dollar"></i></span>
								</div>
								<div class="wrapper">
							
								
								<div id="td" style="margin-left: -230px; margin-top: -60px; " class="box">
									<span><i class="fa fa-clock"></i></span> <b style="color: orange;font-size: 24px;">Destination</b>
									<h3 style="font-size: 20px ;color: black;">
										<c:out value="${e.getDestination()}" />
									</h3>
									<div style="margin-top: -30px;">
									<span><i class="fa fa-clock"></i></span> <b  style="color: orange;font-size: 24px;">Duree</b>
									<h3 style="font-size: 20px ; color: black;">
										<c:out value="${e.getDuree()}" />
									</h3>
										<br>
									</div>
									
									
								</div>
								<div id="td" style="margin-top: -60px;" class="box">
									<span><i class="fa fa-clock"></i></span> <b  style="color: orange;font-size: 24px ;">Description</b>
									<h3 style="font-size: 20px ; color: black;">
										<c:out value="${e.	getDescription()}" />
									</h3>
										<br>
								</div>
									</div>
									<br>
								
								<div class="product-buttons">
								
									<button style="margin-left: 800px;" type="button" class="button-default cart-btn">
										<h3>Decouvrir</h3>
									</button>
								</div>
							</div>
							<br>
					</c:forEach>
				
					







				</div>
					</div> 
			</div>
			<div class="footer-copyright-area">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<div class="footer-copy-right">
								<p>
									Copyright © 2018. All rights reserved. Template by <a
										href="https://colorlib.com/wp/templates/">Colorlib</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>x
		<script>
function myFunction() {
	console.log("dans la fonction");
  // Declare variables
  var input, filter, ul, li, a, i;
  input = document.getElementById("mySearch");
  console.log(input.value);
  filter = input.value.toUpperCase();
  ul = document.getElementById("myMenu");
  li1 = ul.getElementsByTagName("div");
  li = li1.getElementsByTagName("div");
  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    a = li[i].getElementById("td")[2];
    if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
</script>

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