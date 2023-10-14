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
		  <div class="collapse navbar-collapse mx-4" id="navbarTogglerDemo01">
		    <a class="navbar-brand" href="http://localhost:8090/MusicStore/Landing">My Songs</a>
		    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		      <li class="nav-item active">
		        <a class="nav-link" href="http://localhost:8090/MusicStore/main">Home Page</a>
		      </li>
		      
		    </ul>
		   
		  </div>
		</nav>
 	</div>
 	
 	<div class="m-5 d-flex flex-row mb-2">
 		<h2>My Songs</h2>
 		<div class="mx-4">
 			<form action="Landing" mathod="post" class="form-inline my-2 my-lg-0 d-flex flex-row mb-2">
		      <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
		      <button class="btn btn-outline-success my-2 my-sm-0 mx-4" type="submit">Search</button>
		    </form>
 		</div>
 		
 	</div>
 	
 	<div class="m-5">
 		<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">name of the song</th>
      <th scope="col">description</th>
      <th scope="col">Update</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach var="song" items="${songDetails}">
    <tr>
      <td>${song.sid}</td>
      <td>${song.name}</td>
      <td>${song.description}</td>
      
      <td>
		   <a href="http://localhost:8090/MusicStore/UpdateSongByArtist.jsp?id=${song.sid}">
		   	<button type="button" class="btn btn-info">Update</button>
		   </a>
	   </td>
 
      <td>
      	<form method="post" action="DeleteSongServlet">
	      <input type="hidden" name="sid" value="${song.sid}"/>
	      <input type="submit" value="Delete" class="btn btn-danger">
	    </form>      
      </td>  
      
    </tr>
    </c:forEach>
  </tbody>
</table>
 	</div>
 	
 	<div class="m-4">
 		<a href="http://localhost:8090/MusicStore/uploadSongForm.jsp"><button type="button" class="btn btn-dark">Upload New Song</button></a>
 	</div>
 	
 
</body>
</html>