
<%@page import="com.bridgelabz.Model.UserDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script type="text/javascript">


var deleteData = function() {
	var id;
	console.log("Inside the delete");
	email = $("#mail").val();
	console.log(id);
	$.ajax({
		url : 'DeleteAccount',
		type : 'GET',
		success : function(data) {
			$("#bodyId").html(data);
		},
		error : function() {
			alert("error Delete data");
		}
	});
}

/* 

function deleteData(id) {
	console.log("inside javascript");
	$.ajax({
		url : 'DeleteAccount',
		type : 'GET',
		data : {
			id : id
		},
		success : function(result) {
			display(id)
			$('#deleteAccount').modal('show');
		}
	});
}
 */
</script>




</head>

<body>
	<%
		List<UserDetails> list = (List<UserDetails>) request.getAttribute("list");
	%>
	<table class="table table-hover">
		<form method="get">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>AccountNumber</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
		<%
		for (UserDetails user : list) {
		%>
			<tr>
				<td><a class="name"><%=user.getName()%></a></td>
				<td><a class="name"><%=user.getEmail()%></a></td>
				<td><a class="name"><%=user.getAccountnumber()%></a></td>
				<td><button type="button" name="edit" class="btn btn-success">Edit</button></td>
				<td><button type="submit" onclick="return deleteData(<%=user.getId()%>)"  class="btn btn-success">Delete</button></td>
				
			</tr>		
		<%
			}
		%>
		</tbody>
		</form>
	</table>
</body>
</html>