<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">

form {
	margin: 0px 10px;
}

body {
	background: cyan;
}

h2 {
	margin-top: 2px;
	margin-bottom: 2px;
}

.p {
	border: 1px dashed red;
	padding: 10px;
}

.container {
	max-width: 360px;
}

.divider {
	text-align: center;
	margin-top: 20px;
	margin-bottom: 5px;
	background: cyan;
}

.left {
	float: left;
}

.right {
	float: right;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row"">
			<div class="panel panel-primary">
				<div class="panel-body">
					<form method="post" action="Registration"  name="submit">
						<div class="form-group">
							<h2>Create an Account</h2>
						</div>
						<div class="form-group">
							<label class="control-label" for="name">Enter the name</label> <input
								id="name" name="name" type="text" class="form-control"
								placeholder="Enter the name">
						</div>
						<div class="form-group">
							<label class="control-label" for="email">Enter the email</label>
							<input id="email" name="email" type="email"
								placeholder="Enter the email" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="email">Enter the
								password</label> <input id="password" name="password" type="password"
								placeholder="Enter the password" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="password">Confirm
								password</label> <input id="confirmpassword" name="confirmpassword" type="password"
								placeholder="Confirm password" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="number">Enter mobile
								number</label> <input id="mobilenumber" name="mobilenumber" type="text"
								placeholder="Enter mobile number" class="form-control">
						</div>

						<div class="form-group">
							<button id="submit" type="submit"
								class="btn btn-success btn-block">Create my Account</button>
						</div>
						<p class="form-group">
							By clicking on the "Create my Account button "bellow you certify
							that you have read and agree to our <a href="#">Terms of Use</a>
							and our <a href="#">Privacy Policy</a>.
						</p>
						Create an account? <a href="login.jsp">Sign in</a>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>