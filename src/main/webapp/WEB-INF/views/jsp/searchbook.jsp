<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
	<title>Book Library..</title>
</head>
<body>
<div class="container-fluid" >
	<nav>
		<div class="row"> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/addbook">Add Book</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/addsubject">Add Subject</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/deletebook">Delete Book</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/deletesubject">Delete Subject</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/searchbook">Search Book</a> 
			<a class="col-sm-1" href="${pageContext.request.contextPath}/page/searchsubject">Search Subject</a> 
		</div>
	</nav> 
</div>	

<div class="container-fluid center">

  <h4>Search Book Details</h4>  
      <form:form method = "POST" action = "${pageContext.request.contextPath}/searchbookid" modelAttribute="book">      
      		      
      		<div class="row" >
         		<label class="col-sm-2">Id </label>
                <form:input path="bookId" class="col-sm-3"/>
                <label class="col-sm-4"><font color='red'><form:errors path="bookId"/> </font></label>
            </div>
             
             <div class="row">
               <span class="col-sm-1"></span>
               <input class="col-sm-2" type = "submit" value = "View Book"/>  
             </div>                
      </form:form>    
      
      <c:if test="${book.bookId>0}">
      		 <div class="row" >
         		<label class="col-sm-1"> Id </label>
                <label class="col-sm-2"> Title </label>
                <label class="col-sm-1"> Price</label>
                <label class="col-sm-1"> volume</label>
                <label class="col-sm-4"> publish Date</label>
             </div>      	
            <div class="row" >
         		<label class="col-sm-1"> ${book.bookId} </label>
                <label class="col-sm-2"> ${book.title}  </label>
                <label class="col-sm-1"> ${book.price}  </label>
                <label class="col-sm-1"> ${book.volume} </label>
                <label class="col-sm-4"> ${book.publishDate} </label>       
            </div>      
      </c:if>
   </div>     
 </body>
</html>     