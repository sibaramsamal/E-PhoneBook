<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user-dash-board page</title>
<link rel="stylesheet" href="Common-Resources/style.css">
<style>
h1 {
	font-size: 50px;
	font-weight: bolder;
}
</style>
</head>
<body>
	<%@include file="Common-Resources/nav-bar.jsp"%>
	<%
	if (u == null) {
		ss.setAttribute("err-msg", "Please login first!!!");
		response.sendRedirect("user-login.jsp");
	}
	%>
	<div class="container">
		<div class="left-section">
			<h1>Welcome back</h1>
			<%
			if (u != null) {
			%>
			<h2><%=u.getUname()%></h2>
			<%
			}
			%>
		</div>
		<div class="right-section">
			<img src="images/welcome.png">
		</div>
	</div>
	<%@ include file="Common-Resources/footer.jsp"%>
</body>
</html>