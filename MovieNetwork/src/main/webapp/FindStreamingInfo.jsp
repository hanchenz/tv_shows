<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Streaming Info</title>
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
<h1 class="fw-light justify-content-center position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center" style = "text-align:center; color: white; font-size: 40px; font-family: Verdana; background: gray;">See which streaming sites the media is in: </h1>
	<br/>
       <a href="/MovieNetwork/"><button class = "btn btn-info">Go Back</button></a>
	<form action="getStreamingInfo" method="get">
		<p>
		<!-- 	<label for=mediaName>Media Name</label> -->
			<input id="mediaName" name="mediaName" type ="hidden" value="${fn:escapeXml(param.mediaName)}">
		</p> 

	</form>
        <table border="1" class ="table table-striped table-dark">
              <tr class = "thead-light">
                <th>Title</th>
                <th>Type</th>
                <th>Platform</th>
                <th>URL</th>
            </tr>
             <c:forEach items="${streamingInfoByMediaName}" var="streamingInfoByMediaName" >
                <tr>
                    <td><c:out value="${streamingInfoByMediaName.getTitle()}" /></td>
                    <td><c:out value="${streamingInfoByMediaName.getType()}" /></td>
                    <td><c:out value="${streamingInfoByMediaName.getStreamingSite().getStreamingPlatform()}" /></td>
                    <td style="font_size: 50px;  font-family: Verdana; text-align:center;"><a href=<c:out value="${streamingInfoByMediaName.getStreamingSite().getUrl()}" />>link</a></td>
                </tr>
            </c:forEach>
       </table>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
