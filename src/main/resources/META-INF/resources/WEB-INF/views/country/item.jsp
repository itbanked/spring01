<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item.jsp</title>
<!-- code_assist -->
<c:if test="false">
<link rel="stylesheet" href="../code_assist/animate.css">
<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>
</head>
<body>
${error}<br>

<table class="table table-bordered">
	<tr class="bg-info text-warning">
		<th>Country Code</th><th>Country Name</th><th>Country Population</th></tr>
	<tr class="text-info">
		<td>${country.code}</td> <td>${country.name}</td> <td>${country.population}</td>
	</tr>
</table>

<table class="table table-bordered table-striped">
	<tr class="text-danger">
		<th>City Id</th><th>City Name</th><th>City Population</th>
	</tr>
<c:forEach var="citys" items="${country.citys}">
	<tr class="bg-warning text-info">
		<td>${citys.id}</td> <td>${citys.name}</td> <td>${citys.population}</td>
	</tr>
</c:forEach>
</table>

<p style="border:1px solid black;">
${country}
</p>
</body>
</html>