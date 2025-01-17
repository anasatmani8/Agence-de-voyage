<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Star Admin Premium Bootstrap Admin Dashboard Template</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/iconfonts/ionicons/dist/css/ionicons.css">
    <link rel="stylesheet" href="assets/vendors/iconfonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.addons.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="assets/css/shared/style.css">
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/demo_1/style.css">
    <!-- End Layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
  </head>
  
  <body>
    <div class="container-scroller">
      <!-- partial:partials/_navbar.html -->

        <!-- partial -->
        <div class="main-panel">
        <div class="col-12 grid-margin">
                <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">List Voyages<br></h4>
                    <input type="text" id="mySearch" onkeyup="myFunction()" placeholder="Search.." title="Type in a category">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th> </th>
                          <th> Destination </th>
                          <th> Date de depart </th>
                          <th> Date d'arrivée </th>
                          <th> Prix </th>
                          <th> Thèmes </th>
                          <th> Activitées </th>
                        </tr>
                      </thead>
                      
                      <tbody id="myMenu">
                      <c:forEach items="${listVoyages}" var="voy">
                        <tr >
                          <td class="py-1">
                          <img src="data:image/jpg;base64,${voy.base64Image}" width="240" height="300"/>
                          </td>
                          <td> ${ voy.getDestination() } </td>
                          <td>${ voy.getDate_depart() }
                          </td>
                          <td>${ voy.getDate_arrivee() }
                          </td>
                          <td> ${ voy.getPrix() } $ </td>
                          <td><c:forEach items="${voy.getThemes()}" var="theme">
                          <ul>
                          <li>
                           ${ theme.getNom() } 
                           </li>
                           </ul>
                          </c:forEach>
                          </td>
                          <td><c:forEach items="${voy.getActivites()}" var="act">
                          <ul>
                          <li>
                           ${ act.getNom() } 
                           </li>
                           </ul>
                          </c:forEach>
                          </td>
                          <td><a href="supprimerVoy?id_voy=${voy.getId() }" ><i
								class="fa fa-trash-o" aria-hidden="true"></i>Supprimer</a></td>
						  <td><a href="modifierVoy?id_voy=${voy.getId() }" ><i
								class="fa fa-trash-o" aria-hidden="true"></i>Modifier</a></td>
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              </div>
              <footer class="footer">
            <div class="container-fluid clearfix">
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright ©️ bootstrapdash.com 2020</span>
              <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Free <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin templates</a> from Bootstrapdash.com</span>
            </div>
          </footer>
              </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <script>
function myFunction() {
  // Declare variables
  var input, filter, ul, li, a, i;
  input = document.getElementById("mySearch");
  filter = input.value.toUpperCase();
  ul = document.getElementById("myMenu");
  li = ul.getElementsByTagName("tr");
  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    a = li[i].getElementsByTagName("td")[1];
    if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
</script>
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <script src="assets/vendors/js/vendor.bundle.addons.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page-->
    <!-- End plugin js for this page-->
    <!-- inject:js -->
    <script src="assets/js/shared/off-canvas.js"></script>
    <script src="assets/js/shared/misc.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page-->
    <script src="assets/js/demo_1/dashboard.js"></script>
    <!-- End custom js for this page-->
    <script src="assets/js/shared/jquery.cookie.js" type="text/javascript"></script>
  </body>
</html>