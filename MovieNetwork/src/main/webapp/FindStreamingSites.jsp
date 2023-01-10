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
<title>Streaming Sites</title>
</head>
<body>
	<h1>${messages.title}</h1>
         <table border="1" class ="table table-striped table-dark">
            <tr class = "thead-light">
                <th>Streaming Site Id</th>
                <th>Streaming Platform</th>
                <th>URL</th>
            </tr>
            <c:forEach items="${streamingSites}" var="streamingSite" >
                <tr>
                    <td><c:out value="${streamingSite.getStreamingSiteId()}" /></td>
                    <td><c:out value="${streamingSite.getStreamingPlatform()}" /></td>
                    <td><c:out value="${streamingSite.getUrl()}" /></td>
                </tr>
            </c:forEach>
       </table>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
