<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<title>Book Library..</title>
</head>
<body>
<div class="container-fluid" >
	<nav>
		<div class="row"> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/addbook" >Add Book</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/addsubject" >Add Subject</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/deletebook" >Delete Book</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/deletesubject" >Delete Subject</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/searchbook" >Search Book</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/searchsubject" >Search Subject</a> 
		</div>
	</nav> 
</div>	
</body>
</html>