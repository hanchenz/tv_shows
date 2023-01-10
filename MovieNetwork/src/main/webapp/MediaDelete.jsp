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
<title>Delete Media</title>
<style>
	body {
	  background-image: url("moviebackground.jpg");
	  background-repeat: no-repeat;
	  background-attachment: fixed;
	  background-size: cover;
	}
</style>
</head>
<body>
<br/>
	<div  style="width : 25rem; " class="card text-center mx-auto" >
	<div class = "card-body">
    <h2 class = "card-title">Delete</h2>
    <form action="mediadelete" method="post">
        <p>
            <input type="hidden" id="titleId" name="titleId" value="${titleId}">
        </p>
        <p>
            <input type="submit" class="btn btn-danger">
        </p>
    </form>
    <br/><br/>

	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
	
    <a href="/MovieNetwork/"><button class = "btn btn-secondary"> Go Back</button></a>
	</div>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
</body>
</html>
