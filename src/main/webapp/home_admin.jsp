<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Espace Admin</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Google fonts - Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<!-- Choices CSS-->
<link rel="stylesheet"
	href="vendor/choices.js/public/assets/styles/choices.min.css">
<!-- Custom Scrollbar-->
<link rel="stylesheet"
	href="vendor/overlayscrollbars/css/OverlayScrollbars.min.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon" href="img/favicon.ico">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>

<body>
	<!-- Side Navbar -->
	<nav class="side-navbar">
		<!-- Sidebar Header    -->
		<div
			class="sidebar-header d-flex align-items-center justify-content-center p-3 mb-3">
			<!-- User Info-->
			<div class="sidenav-header-inner text-center">
				<img class="img-fluid rounded-circle avatar mb-3"
					src="img/us.jpg" alt="person">
				<h2 class="h5 text-white text-uppercase mb-0">

					<% 
			out.println(session.getAttribute("utilsateur"));
		%>
				</h2>


			</div>
		</div>
		<!-- Sidebar Navigation Menus-->
		<span
			class="text-uppercase text-gray-500 text-sm fw-bold letter-spacing-0 mx-lg-2 heading">Main</span>
		<ul class="list-unstyled">
			<li class="sidebar-item"><a class="sidebar-link"
				href="index.html"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy me-xl-2">
              
            </svg>Home
			</a></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="ListeVoyage"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy me-xl-2">
          
            </svg>Voyage en famille
			</a></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="ListeVoyageAcc"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy me-xl-2">
          
            </svg>Voyage accompagné
			</a></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="afficherAllVille"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy me-xl-2">
          
            </svg>Hotel
			</a></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="ajouterVille.jsp"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy me-xl-2">
          
            </svg>Ville
			</a></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="ajouterActivite.jsp"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy me-xl-2">
          
            </svg>Activite
			</a></li>



			<li class="sidebar-item"><a class="sidebar-link"
				href="logout"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy me-xl-2">
            </svg>Log out
			</a></li>

		</ul>
	</nav>

	<!-- navbar-->
	<header class="header">
		<nav class="navbar">
			<div class="container-fluid">
				<a style="" class="navbar-brand ms-2" href="index.html"> <span
					class="text-white fw-normal text-xs"> </span><strong
					class="text-primary text-sm"></strong></a>
			</div>


		</nav>
	</header>
	<!-- Counts Section -->

	<!-- Header Section-->

	<!-- Statistics Section-->

	<!-- Updates Section -->



	<!-- JavaScript files-->
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/just-validate/js/just-validate.min.js"></script>
	<script src="vendor/choices.js/public/assets/scripts/choices.min.js"></script>
	<script src="vendor/overlayscrollbars/js/OverlayScrollbars.min.js"></script>
	<script src="js/charts-home.js"></script>
	<!-- Main File-->
	<script src="js/front.js"></script>
	<script>
      // ------------------------------------------------------- //
      //   Inject SVG Sprite - 
      //   see more here 
      //   https://css-tricks.com/ajaxing-svg-sprite/
      // ----h-------------------------------------------------- //
      function injectSvgSprite(path) {
      
          var ajax = new XMLHttpRequest();
          ajax.open("GET", path, true);
          ajax.send();
          ajax.onload = function(e) {
          var div = document.createElement("div");
          div.className = 'd-none';
          div.innerHTML = ajax.responseText;
          document.body.insertBefore(div, document.body.childNodes[0]);
          }
      }
      // this is set to BootstrapTemple website as you cannot 
      // inject local SVG sprite (using only 'icons/orion-svg-sprite.svg' path)
      // while using file:// protocol
      // pls don't forget to change to your domain :)
      injectSvgSprite('https://bootstraptemple.com/files/icons/orion-svg-sprite.svg'); 
      
      
    </script>
	<!-- FontAwesome CSS - loading as last, so it doesn't block rendering-->
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
		integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
		crossorigin="anonymous">
</body>
</html>