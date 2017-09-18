<%@page import="com.bridgelabz.Model.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
	List<UserBean> list = (List<UserBean>) request.getAttribute("list");
	%>
	<ol>
		<%
		for (UserBean userBean : list) {
		%>
		<li><a class='city' id='city<%=userBean.getId()%>' href='#'><%=userBean.getCity()%> </a>
			<a href="DeleteAccount" class='form-pull-right book-delete' id='delete<%=userBean.getId()%>'>delete</a>
			<a href="UpdateAccount" class='form-pull-right book-edit' id='edit<%=userBean.getId()%>'>edit</a>
		</li>
		<%
			}
		%>
	</ol>
</body>
</html>