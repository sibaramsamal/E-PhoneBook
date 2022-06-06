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
	form{
		height: 250px;
	}
</style>
</head>
<body>
	<%@include file="Common-Resources/nav-bar.jsp" %>
	<div class="container">
		<div class="left-section">
			<form action="login" method="post">
				<h1>Login Form</h1>
				<%
					String msg = (String)ss.getAttribute("err-msg");
					if(msg != null){
				%>
					<h4 class="txt-danger"><%= msg %></h4>
				<%
					ss.removeAttribute("err-msg");
					}
				%>
				<input type="email" name="user-id" placeholder="Enter your Mail ID">
				<input type="password" name="pass" placeholder="Enter your password">
				<input type="submit" class="btn-form" value="Login">
				<input type="reset" class="btn-form" value="Cancel">
			</form>
		</div>
		<div class="right-section">
			<img src="images/login-register.svg">
		</div>
	</div>
	<%@include file="Common-Resources/footer.jsp" %>
</body>
</html>