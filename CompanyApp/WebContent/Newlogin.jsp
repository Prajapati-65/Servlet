<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.sql.*, java.io.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<!-- jQuery library -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->

<!-- Latest compiled JavaScript -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->


<script type="text/javascript">
	function validatelogin() {

		var email = document.getElementById('email');
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

		var password = document.getElementById('pwd');
		var pass = password.value;

		if (!filter.test(email.value)) {
			alert("Enter valid Email");
			return false;
		}

		if (pass == "" || pass == null) {
			alert("Enter Password correctly");
			return false;
		}
	}
</script>

</head>
<style>
.container {
	margin-top: 100px;
}

.formlogin {
	/* border:2px solid; */
	background-color: #f0f5f5;
	padding-bottom: 40px;
	padding-top: 10px;
	padding-left: 20px;
	padding-right: 20px;
}

#h2login {
	text-align: center;
}
</style>
<body>
	<%
		if ((Integer) session.getAttribute("userid") == null) {
	%>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-3 col-sm-2"></div>
			<div class="col-lg-4 col-md-6 col-sm-8">

				<form role="form" action="LoginServlet" method="Post"
					class="formlogin">
					<h2 id="h2login">Login Form</h2>
					<div class="form-group">
						<label for="email">&nbsp Email</label> <input type="email"
							class="form-control" id="email" placeholder="Enter email"
							name="email">
					</div>
					<div class="form-group">
						<label for="pwd">&nbsp Password</label> <input type="password"
							class="form-control" id="pwd" placeholder="Enter password"
							name="password">
					</div>
					<%
						String msg = (String) session.getAttribute("errormsg");
							System.out.println("Error msg is ::" + msg);
							if (msg != null) {
					%>
					<div>
						<p style="color: red; text-align: center">
							<%
								out.println(msg);
							%>
						</p>
					</div>
					<%
						}
					%>
					<input id="sublog" type="submit" value="Login"
						onclick="return validatelogin()" class="btn btn-success btn-block">
					<button formaction="Preuserreg" class="btn btn-primary btn-block">SignUp</button>
					<!-- 	Not Registered yet ? click here      <a href="Preuserreg">SignUp </a> -->
				</form>
			</div>
		</div>
		<div class="col-lg-4 col-md-3 col-sm-2"></div>
	</div>
	<%
		} else {
			response.sendRedirect("Employee");
		}
	%>

</body>
</html>