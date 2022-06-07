<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>nav-bar</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="nav_bar">
		<div class="logo">
			<h1>E-PhoneBook</h1>
		</div>
		<%
		HttpSession ss = request.getSession();
		User u = (User) ss.getAttribute("user");
		if (u == null) {
		%>
		<div class="menu">
			<a href="index.jsp">Home</a> <a href="add-contact.jsp">Add
				contact</a> <a href="view-contacts.jsp">View Contact</a>
		</div>
		<div class="buttons">
			<a class="btn" href="user-login.jsp">Login</a> 
			<a class="btn" href="user-register.jsp">Register</a>
		</div>
		<%
		}
		if (u != null) {
		%>
			<div class="menu">
				<a href="index.jsp">Home</a> <a href="add-contact.jsp">Add
					contact</a> <a href="view-contacts.jsp">View Contact</a>
			</div>
			<div class="buttons">
				<h2><%=u.getUname()%></h2>
				<a class="btn" href="logout">Logout</a>
			</div>
			<%
			}
			%>
	</div>
</body>
</html>