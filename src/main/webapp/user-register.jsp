<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user-registration page</title>
<link rel="stylesheet" href="Common-Resources/style.css">
<style type="text/css">
	.right-section img {
		width: 800px;
		margin-right: 70px;
	}
	form{
		height: 300px;
	}
</style>
</head>
<body>
	<%@include file="Common-Resources/nav-bar.jsp" %>
	<div class="container">
		<div class="left-section">
			<form action="register" method="post">
			<h1>Registration Form</h1>
			<%
				HttpSession ss = request.getSession();
				String successMsg = (String)ss.getAttribute("suc-msg");
				if(successMsg != null){
			%>
			<h5 class="txt-green"><%= successMsg %>, For login click <a href="user-login.jsp">here</a></h5>
			<%
				ss.removeAttribute("suc-msg");
				}
			%>
			<%
				HttpSession ses = request.getSession();
				String errorMessage = (String)ss.getAttribute("fail-msg");
				if(errorMessage != null){
			%>
				<h3 class="txt-danger"><%= errorMessage %></h3>
			<%
				ses.removeAttribute("fail-msg");
				}
			%>
				<input type="text" name="user-name" placeholder="Enter your name" required="required">
				<input type="email" name="user-id" placeholder="Enter your Email ID" required="required">
				<input type="password" name="pass" placeholder="Enter your password" required="required">
				<input type="submit" value="Register" class="btn-form">
				<input type="reset" value="Cancel" class="btn-form">
			</form>
		</div>
		<div class="right-section">
			<img src="images/login-register.svg">
		</div>
	</div>
	<%@include file="Common-Resources/footer.jsp" %>
</body>
</html>