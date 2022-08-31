<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Login | Kiaalap - Kiaalap Admin Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Play:400,700" rel="stylesheet">
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
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="kiaalap-master/css/main.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="kiaalap-master/css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="kiaalap-master/css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="kiaalap-master/css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="kiaalap-master/css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="kiaalap-master/css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="kiaalap-master/css/calendar/fullcalendar.print.min.css">
    <!-- forms CSS
		============================================ -->
    <link rel="stylesheet" href="kiaalap-master/css/form/all-type-forms.css">
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
    <!--[if lt IE 8]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	<![endif]-->
	<div class="error-pagewrap">
		<div class="error-page-int">
			<div class="text-center m-b-md custom-login">
				<h3>PLEASE LOGIN TO APP</h3>
			
			</div>
			<div class="content-error">
				<div class="hpanel">
                    <div class="panel-body">
                        <form action="loginFirst" method="post" id="loginForm">
                            <div class="form-group">
                            <input type="hidden" name="idDatevoyage" value="${id}">
                            <input type="hidden" name="idClient" value="">
                                <label class="control-label" for="username">Username</label>
                                <input type="text" placeholder="example@gmail.com" title="Please enter you username" required value="" name="username" id="username" class="form-control">
                                <span class="help-block small">Your unique username to app</span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="password">Password</label>
                                <input type="password" title="Please enter your password" placeholder="******" required value="" name="password" id="password" class="form-control">
                                <span class="help-block small">Your strong password</span>
                            </div>
                            <div class="checkbox login-checkbox">
                                <label>
										<input type="checkbox" class="i-checks"> Remember me </label>
                                <p class="help-block small">(if this is a private computer)</p>
                            </div>
                            <button class="btn btn-success btn-block loginbtn">Login</button>
                            <a class="btn btn-default btn-block" href="register.jsp">Register</a>
                        </form>
                    </div>
                </div>
			</div>
			<div class="text-center login-footer">
				<p>Copyright © 2018. All rights reserved. Template by <a href="https://colorlib.com/wp/templates/">Colorlib</a></p>
			</div>
		</div>   
    </div>
    <!-- jquery
		============================================ -->
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
    <script src="kiaalap-master/js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="kiaalap-master/js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="kiaalap-master/js/metisMenu/metisMenu.min.js"></script>
    <script src="kiaalap-master/js/metisMenu/metisMenu-active.js"></script>
    <!-- tab JS
		============================================ -->
    <script src="kiaalap-master/js/tab.js"></script>
    <!-- icheck JS
		============================================ -->
    <script src="kiaalap-master/js/icheck/icheck.min.js"></script>
    <script src="kiaalap-master/js/icheck/icheck-active.js"></script>
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