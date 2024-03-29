<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Re-Authenticate</title>

<!-- Bootstrap CSS -->
<link href="plugins/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="plugins/css/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- Toastr -->
<link href="plugins/css/toastr.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/app.css" rel="stylesheet">

</head>

<body>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Header -->
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header">
					Security check <small>Secure Web Application <i>GTI-619</i></small>
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Notifications -->
		<div id="messageCallback" hidden=true>${messageCallback}</div>

		<!-- Projects Row -->
		<div class="row">
			<div class="col-md-12">

				<div class="col-md-6 col-md-offset-3">

					<div class="panel">
						<h3>Password</h3>
						<hr>
						<h4>Type in your current password</h4>
						<form name="connexion" method="POST" role="form">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="password" type="password" required>
								</div>
								<div class="col-md-6 col-md-offset-3">
									<button type="submit" class="btn btn-lg btn-success btn-block ">Submit</button>
								</div>
								<br>
							</fieldset>
						</form>
					</div>
				</div>


			</div>
			<!-- /.col-md-12 -->
		</div>
		<!-- /.row -->



		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-md-12">
					<p>Copyright &copy; LAB5 - 2016</p>
				</div>
			</div>
			<!-- /.row -->
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="plugins/js/jquery-2.2.4.min.js"></script>
	<!-- Bootstrap JS -->
	<script src="plugins/js/bootstrap.min.js"></script>
	<!-- Toastr JS -->
	<script src="plugins/js/toastr.min.js"></script>

	<!-- Custom JS -->
	<script src="js/notification.js"></script>
</body>

</html>