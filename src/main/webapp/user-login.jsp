<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new-user-login page</title>
<link rel="stylesheet" href="Common-Resources/style.css">
<style>
	.container{
		justify-content: space-between;
	}
	.right-section img {
	width: 800px;
	margin-right: 70px;
}
</style>
</head>
<body>
	<%@include file="Common-Resources/nav-bar.jsp" %>
	<div class="container">
		<div class="left-section">
			<form action="/login" method="post">
			
			</form>
		</div>
		<div class="right-section">
			<image src="images/login-register.svg">
		</div>
	</div>
	<%@include file="Common-Resources/footer.jsp" %>
</body>
</html>