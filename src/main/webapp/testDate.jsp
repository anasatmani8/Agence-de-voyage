<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-6">
		<div class="form-group row">
			<label class="col-sm-3 col-form-label">Date de depart</label>
			<div class="col-sm-9">
				<input placeholder="dd/mm/yyyy" type="date"
					min="<%= new java.sql.Date(System.currentTimeMillis()) %>"
					name="date_depart" class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-3 col-form-label">Date de retour</label>
			<div class="col-sm-9">
				<input id="dr" class="form-control" type="date" name="date_fin" />
			</div>
		</div>

	</div>
	<script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>


<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
                            

                            $(document).ready(function() {
    $('input[name=date_fin]').click(function() {
        verifi();
    });
});
function verifi() {
    var dd = $('input[name=date_depart]').val();
    var da = $('input[name=date_fin]').val();
    document.getElementById('dr').setAttribute("min",dd);
    console.log(dd);
}
                        </script>
</body>
</html>