<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add-new-contat page</title>
<link rel="stylesheet" href="Common-Resources/style.css">
<style type="text/css">
	.container{
		justify-content: space-between;
	}
	form{
		height: 350px;
	}
	.right-section img {
		width: 800px;
		margin-right: 70px;
	}
</style>
</head>
<body>
	<%@include file="Common-Resources/nav-bar.jsp"%>
	<div class="container">
		<div class="left-section">
			<form action="/add-contact" method="post">
				<h1>Add new Contact</h1>
				<input type="text" name="c-name" placeholder="Enter contact name" required="true"><br>
				<input type="email" name="mail" placeholder="Enter mail-ID" required="true"><br>
				<input type="text" name="number" placeholder="Enter phone no." required="true"><br>
				<input type="text" name="about" placeholder="Additional details" required="true"><br>
				<input type="submit" class="btn-form" value="Save Contact"> 
				<input type="reset" class="btn-form" value="Cancel">
			</form>
		</div>
		<div class="right-section">
			<image src="images/add-contact.svg">
		</div>
	</div>
	<%@include file="Common-Resources/footer.jsp"%>
</body>
</html>