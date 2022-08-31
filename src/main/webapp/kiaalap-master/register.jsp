<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Password Meter | Kiaalap - Kiaalap Admin Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/owl.theme.css">
    <link rel="stylesheet" href="css/owl.transitions.css">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="css/normalize.css">
    <!-- meanmenu icon CSS
		============================================ -->
    <link rel="stylesheet" href="css/meanmenu.min.css">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="css/main.css">
    <!-- educate icon CSS
		============================================ -->
    <link rel="stylesheet" href="css/educate-custon-icon.css">
    <!-- morrisjs CSS
		============================================ -->
    <link rel="stylesheet" href="css/morrisjs/morris.css">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="css/scrollbar/jquery.mCustomScrollbar.min.css">
    <!-- metisMenu CSS
		============================================ -->
    <link rel="stylesheet" href="css/metisMenu/metisMenu.min.css">
    <link rel="stylesheet" href="css/metisMenu/metisMenu-vertical.css">
    <!-- calendar CSS
		============================================ -->
    <link rel="stylesheet" href="css/calendar/fullcalendar.min.css">
    <link rel="stylesheet" href="css/calendar/fullcalendar.print.min.css">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="style.css">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- modernizr JS
		============================================ -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<style type="text/css">

	body {
color:black;
object-fit: cover;
background-image:url(css/backimage.jpg);
 background-repeat: no-repeat;
 background-size: contain;
}

</style>
<body>
	 <div style="margin-left: 730px;margin-top: -30px;" class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="sparkline9-list mg-t-30">
                            <div class="sparkline9-hd">
                                <div class="text-center custom-login">
				<h3>Registration</h3>
				
			</div>
                            </div>
                            <div class="sparkline9-graph">
                                <div id="pwd-container4">
                                <form action="../createAccount" method="post">
                                    <div class="form-group">
                                        <label for="y ear">Nom</label>
                                        <input type="text" class="form-control" id="year" name="nomC">
                                    </div>
                                    <div class="form-group">
                                        <label for="y ear">Prenom</label>
                                        <input type="text" class="form-control" id="year" name="prenomC">
                                    </div>
                                    <div class="form-group">
                                        <label for="y ear">Telephone</label>
                                        <input type="text" class="form-control" id="year" name="telephoneC">
                                    </div>
                                    <div class="form-group">
                                        <label for="y ear">CNE</label>
                                        <input type="text" class="form-control" id="year" name="CNE">
                                    </div>
                                    <div class="form-group">
                                        <label for="y ear">Carte bancaire</label>
                                        <input type="text" class="form-control" id="year" name="carte_bancaire">
                                    </div>
                                    <div class="form-group">
                                        <label for="y ear">Adresse</label>
                                        <input type="text" class="form-control" id="year" name="adresseC">
                                    </div>

                                    <div class="form-group">
                                        <label for="familyname">Username</label>
                                        <input type="text" class="form-control" id="familyname" placeholder="Username" name="username">
                                    </div>
                                    <div class="form-group">
                                        <label for="password4">Password</label>
                                        <input type="password" class="form-control example4" id="password4" name="password"  placeholder="Password">
                                    </div>

                                    <div class="form-group mg-b-pass">
                                        <span class="font-bold pwstrength_viewport_verdict4"></span>
                                        <span class="pwstrength_viewport_progress4"></span>
                                    </div>
                                    <div class="text-center">
                                <button class="btn btn-success loginbtn">Register</button>
                                <button class="btn btn-default">Cancel</button>
                            </div>
                            </form>
                                </div>
                            </div>
                        </div>
                    </div>
 

  <!-- jquery
		============================================ -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <!-- bootstrap JS
		============================================ -->
    <script src="js/bootstrap.min.js"></script>
    <!-- wow JS
		============================================ -->
    <script src="js/wow.min.js"></script>
    <!-- price-slider JS
		============================================ -->
    <script src="js/jquery-price-slider.js"></script>
    <!-- meanmenu JS
		============================================ -->
    <script src="js/jquery.meanmenu.js"></script>
    <!-- owl.carousel JS
		============================================ -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- sticky JS
		============================================ -->
    <script src="js/jquery.sticky.js"></script>
    <!-- scrollUp JS
		============================================ -->
    <script src="js/jquery.scrollUp.min.js"></script>
    <!-- mCustomScrollbar JS
		============================================ -->
    <script src="js/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/scrollbar/mCustomScrollbar-active.js"></script>
    <!-- metisMenu JS
		============================================ -->
    <script src="js/metisMenu/metisMenu.min.js"></script>
    <script src="js/metisMenu/metisMenu-active.js"></script>
    <!-- pwstrength JS
		============================================ -->
    <script src="js/password-meter/pwstrength-bootstrap.min.js"></script>
    <script src="js/password-meter/zxcvbn.js"></script>
    <script src="js/password-meter/password-meter-active.js"></script>
    <!-- tab JS
		============================================ -->
    <script src="js/tab.js"></script>
    <!-- plugins JS
		============================================ -->
    <script src="js/plugins.js"></script>
    <!-- main JS
		============================================ -->
    <script src="js/main.js"></script>
    <!-- tawk chat JS
		============================================ -->
    <script src="js/tawk-chat.js"></script>
</body>

</html>