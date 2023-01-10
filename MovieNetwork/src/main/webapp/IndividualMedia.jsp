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
<title>Movie</title>
</head>
<style>
	body {
	  background-image: url("moviebackground.jpg");
	  background-repeat: no-repeat;
	  background-attachment: fixed;
	  background-size: cover;
	}
</style>
<body class="position-relative overflow-hidden p-3 p-md-5 m-md-3 bg-light">
	<input type="hidden" id="titleId" name="titleId" value="${titleId}">
	<input type="hidden" id="media" name="media" value="${media}">
	<h1 class="fw-light justify-content-center position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center" style = "text-align:center; color: white; font-size: 40px; font-family: Verdana; background: gray;"><c:out value="${media.getTitle()}" /></h1>
        <table border="1" class ="table table-striped table-dark">
            <tr class = "thead-light">
                <th>Year</th>
                <th>Actor</th>
                <th>ImdbRating</th>
                <th>ImdbNumberofVotes</th>
                <th>RottenTomatoesCriticRating</th>
                <th>RottenTomatoesAudienceRating</th>
                <th>StreamingPlatform</th>
                <th>Genre</th>
                <th>BookURL</th>
            </tr>
            <tr>
                <td><c:out value="${media.getYear()}" /></td>
                <td><c:out value="${media.getActor()}" /></td>
                <td><c:out value="${media.getImdbAudience()}" /></td>
                <td><c:out value="${media.getImdbNumVotes()}" /></td>
                <td><c:out value="${media.getRottenCritic()}" /></td>
                <td><c:out value="${media.getRottenAudience()}" /></td>
                <td><c:out value="${media.getStreamingPlatform()}" /></td>
                <td><c:out value="${media.getGenres()}" /></td>
                <td><c:out value="${media.getURL()}" /></td>
           
            </tr>
       </table>
       
        <a href="/MovieNetwork/"><button class = "btn btn-info">Go Back</button></a>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
