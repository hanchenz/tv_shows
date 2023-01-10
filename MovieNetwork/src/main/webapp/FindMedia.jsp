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
<title>Find a Movie or TV Show</title>
</head>
<style> 
body {
  background-image: url("moviebackground.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}

a {
  /* background-color: white; */
  color: #64D6BE;
  padding: 0.5em 0.3em;
  text-decoration: none;
  text-transform: uppercase;
  font-family : Verdana;
  font-size: 25px;
  font-weight: bold;
}

</style>

<body class = "position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
	<form action="findmedia" method="post" class = "col-md-10 p-lg-5 mx-auto my-5" style="background: gray;">
		<h1 class="fw-light justify-content-center" style = "text-align:left; color: white; font-size: 60px; font-family: Verdana;">Welcome to the Movie Network!</h1>
		<br/>
		<div style = "text-align:center">
			<div class = "form-inline mt-2 mt-md-0">
				<label for="medianame" style = "color: white; font-size: 25px; font-family: Verdana;" >Movie or TV Show Search:  </label>
			
				<input id="medianame" name="medianame"  class="form-control mr-sm-2" value="${fn:escapeXml(param.medianame)}">
			
				<input type="submit" class="btn btn-info">
			</div>
			<br/>
			
			<div class = "form-inline mt-2 mt-md-0">
				<label for="medianame" style = "color: white; font-size: 25px; font-family: Verdana;"> If searched media is not found, click   </label>
				<div id="mediaCreate" style = "font_size: 50px;  font-family: Verdana; text-align:center;" ><a href="mediacreate"> HERE</a></div>
				<label style = "color: white;font-size: 25px; font-family: Verdana;">  to add to listing. </label>
			</div>
		</div>
	</form>
	<br/>
	<h1 id="successMessage" style = "center;"><b>${messages.success}</b></h1>
        <table border="1" class ="table table-striped table-dark">
            <tr class = "thead-light">
            	<th>TitleId</th>
                <th>Title</th>
                <th>Year</th>
                <th>Genre</th>
                <th>Streaming</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${mediaList}" var="media" >
                <tr>
                    <td>
                    	<a href="individualmedia?titleId=<c:out value="${media.getMovieId()}"/>">
                    		<c:out value="${media.getMovieId()}" />
                    	</a>
                    </td>
                    <td><c:out value="${media.getTitle()}" /></td>
                    <td><c:out value="${media.getStartYear()}" /></td>
                    <td><c:out value="${media.getGenres()}" /></td>
                    <td><a href="getStreamingInfo?mediaName=<c:out value="${media.getTitle()}"/>">Streaming Info </a></td>
                    <td><a href="mediaupdate?titleId=<c:out value="${media.getMovieId()}"/>">Update</a></td>
                    <td><a href="mediadelete?titleId=<c:out value="${media.getMovieId()}"/>">Delete</a></td>
					
                </tr>
            </c:forEach>
       </table>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
