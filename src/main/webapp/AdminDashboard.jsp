<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
   
 	<div>
 	
 		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
		    <a class="navbar-brand" href="#">Hidden brand</a>
		    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		      <li class="nav-item active">
		        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="#">Link</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link disabled" href="#">Disabled</a>
		      </li>
		    </ul>
		    <form class="form-inline my-2 my-lg-0">
		      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
		      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		    </form>
		  </div>
		</nav>
 	</div>
 	
 	<div>
	 <table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Id</th>
	      <th scope="col">name</th>
	      <th scope="col">username</th>
	      <th scope="col">password</th>
	      <th scope="col">Update</th>
	      
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<c:forEach var="artist" items="${allArtist}">
	    <tr>
	      <td>${artist.id}</td>
	      <td>${artist.name}</td>
	      <td>${artist.username}</td>
	 	  <td>${artist.password}</td>
	      
	      	<td>
	            <a href="http://localhost:8090/MusicStore/UpdateArtist.jsp?id=${artist.id}">
	                <button type="button" class="btn btn-danger">Update</button>
	            </a>
	        </td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
 	</div>
 	
 	<a href="http://localhost:8090/MusicStore/AddArtist.jsp"><button type="button" class="btn btn-dark">Add new artist</button></a>
 
 
 	
 	<div>
	 <table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Id</th>
	      <th scope="col">Description</th>
	      
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<c:forEach var="term" items="${allTerms}">
		    <tr>
		      <td>${term.tid}</td>
		      <td>${term.description}</td>
		      
		      
		      	<td>
		            <a href="http://localhost:8090/MusicStore/UpdateTerms.jsp?id=${term.tid}">
		                <button type="button" class="btn btn-danger">Update</button>
		            </a>
		        </td>
		    </tr>
	    </c:forEach>
	    
	    
	  </tbody>
	</table>
 	</div>
 	
 	<a href="http://localhost:8090/MusicStore/AddArtist.jsp"><button type="button" class="btn btn-dark">Add new artist</button></a>
</body>
</html>