<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Create a Media</title>
</head>
<style>
	body {
	  background-image: url("moviebackground.jpg");
	  background-repeat: no-repeat;
	  background-attachment: fixed;
	  background-size: cover;
	}
</style>
<body>
	<br/>
	<div  style="width : 25rem; " class="card text-center mx-auto" >
		<div class = "card-body">
			<h2 class = "card-title">Create Media</h2>
			<form action="mediacreate" method="post">
			  <ul class="list-group list-group-flush">
			  
					<li class="list-group-item">
						<label for="titleId">TitleId</label>
						<input id="titleId" name="titleId" value="">
					</li>
					
					<li class="list-group-item">
						<label for="movieType">MovieType</label>
						<input id="movieType" name="movieType" value="">
					</li>
					<li class="list-group-item">
						<label for="title">Title</label>
						<input id="title" name="title" value="">
					</li>
					<li class="list-group-item">
						<label for="year">Year</label>
						<input id="year" name="year" value="">
					</li>
					<li class="list-group-item">
						<label for="isAdult">Adult (true/false)</label>
						<input id="isAdult" name="isAdult" value="">
					</li>
					<li class="list-group-item">
						<label for="runtime">Runtime Minutes</label>
						<input id="runtime" name="runtime" value="">
					</li>
					<li class="list-group-item">
						<label for="genres">Genre</label>
						<input id="genres" name="genres" value="">
					</li>

 			  </ul>
 			  <br/>
					<input type="submit" class="btn btn-info">
			</form>
			<br/>
			<a href="/MovieNetwork/"><button class = "btn btn-secondary"> Go Back</button></a>
		</div>
	</div>
	<br/><br/>
	<p>
		<h1 id="successMessage" style = "text-align:center; color:white;"><b>${messages.success}</b></h1>
	</p>
	
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>