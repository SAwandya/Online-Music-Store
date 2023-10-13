<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bookmark-plus" viewBox="0 0 16 16">
	  <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z"/>
	  <path d="M8 4a.5.5 0 0 1 .5.5V6H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V7H6a.5.5 0 0 1 0-1h1.5V4.5A.5.5 0 0 1 8 4z"/>
	</svg>
	<title>Music store</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-icons.min.css">
	<link rel="stylesheet" type="text/css" href="css/custom.css">
	
</head>
<body>

	<!--start main area-->
	<main>
		<!--start navigation-->
		<nav class="mainnav shadow navbar-expand-lg navbar navbar-dark bg-dark fixed-top" style="min-width: 350px">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">
		    	<i class="bi bi-soundwave"></i> Music store
		    	
		    </a>

		    <div>
			    <div class="input-group ">
			    <div class="mx-4">
	 			<form action="main" mathod="post" class="form-inline my-2 my-lg-0 d-flex flex-row mb-2">
			      <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
			      <button class="btn btn-outline-success my-2 my-sm-0 mx-4" type="submit">Search</button>
			    </form>
 		</div>
				</div>
			</div>

			
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
		      
		      <li class="nav-item"> 
		          <a class="nav-link active" aria-current="page" href="#">Home</a>
		        </li>
		      	
		      	<c:if test="${empty sessionScope.customerList}">
			      	<li class="nav-item"> 
			          <a aria-current="page" href="http://localhost:8090/MusicStore/RegisterForm.jsp"><button type="button" id="regButton" class="btn btn-light mx-3">Register</button></a>
			        </li>
		        </c:if>
		        
		        <c:if test="${empty sessionScope.customerList}">
		        
		        
		        <li class="nav-item"> 
			         <a aria-current="page" href="http://localhost:8090/MusicStore/UserLogin.jsp"><button type="button" id="logButton" class="btn btn-light">Sign in</button></a>
			      </li>
		        </c:if>
		        
		        
		        <li class="nav-item">
		          <a aria-current="page" href="http://localhost:8090/MusicStore/RegisterForm.jsp"><button type="button" id="regButton" class="btn btn-light mx-3">Register as an Artist</button></a>
		        </li>
		        <li class="nav-item">
		          <a aria-current="page" href="http://localhost:8090/MusicStore/RegisterForm.jsp"><button type="button" id="regButton" class="btn btn-light mx-3">Artist Login</button></a>
		        </li>
		       
		        
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Genre
		          </a>
		          <ul class="dropdown-menu bg-dark" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item text-white" href="#">Pop</a></li>
		            <li><a class="dropdown-item text-white" href="#">R&B</a></li>
		            <li><hr class="dropdown-divider"></li>
		            <li><a class="dropdown-item text-white" href="#">Country</a></li>
		          </ul>
		        </li>

		        <img class="rounded-circle" src="images/06.jpg" style="width:40px;height:40px">
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            <c:forEach var="cus" items="${customerList}">
		            	${cus.name}
		            </c:forEach>
		          </a>
		          <ul class="dropdown-menu dropdown-menu-end bg-dark" aria-labelledby="navbarDropdown">
		            <li><a class="dropdown-item text-white" href="#"><i class="bi bi-person"></i> Profile</a></li>
		            <li><a class="dropdown-item text-white" href="#"><i class="bi bi-gear"></i> Settings</a></li>
		            <li><hr class="dropdown-divider"></li>
		            
		            <c:if test="${not empty sessionScope.customerList}">
		            	<form method="get" action="main">
		            	<input type="hidden" name="log" value="logout"/>
		            	<li><input class="dropdown-item text-white" type="submit" value="Log out"/></li>
		            	</form>
		            </c:if>
		            
		          </ul>
		          
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav><!--end navigation-->


		<!--start hero area-->
		<div class="hero-area text-white pt-5 mt-2">
			
			<div class="nav-spacer"></div>

			<ul class="hero-nav nav m-4 nav-pills mb-3" id="pills-tab" role="tablist">
			  <li class="nav-item" role="presentation">
			    <button class="text-white nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home" aria-selected="true">Library</button>
			  </li>
			</ul>
			<div class="tab-content" id="pills-tabContent">
			  <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">

			  		<!--small song item-->
			  		<c:forEach var="song" items="${LibraryDetails}">
				  		<div class="song-small m-1 ms-4 col-md-6 row align-items-center" >
				  			<div class="col-1 h3">${song.sid}</div>
				  			<div class="col d-flex">
				  				<img class="song-small-img rounded m-1" src="images/06.jpg" >
				  				<div class="ms-1">
				  					<div>${song.name}</div>
						  			<small>${song.description}</small>
						  		</div>
						  		
					  		</div>
				  			<div class="col-2">05:00 <i class="bi bi-play"></i></div>
				  			<div class="col-3" >
				  				<form method="post" action="DeleteFromLibrary">
				  					<input type="hidden" name="sid" value="${song.sid}"/>
				  					<input type="submit" value="remove" class="btn btn-outline-light">
				  				</form>
						  		
						  	</div>
				  		</div>
			  		</c:forEach>
			  </div>
		
			</div>


		</div>
		<!--end hero area-->

		<h5 class="song-category-title mx-5 pt-4">All Music <small class="float-end"><a href="">View more <i class="bi bi-box-arrow-up-right"></i></a></small></h5>

		<!-- start category area-->
		<section class="pt-2 p-4 mx-5 d-flex justify-content-center" style="flex-wrap: wrap;">
			
			
			<!--song card start-->
			
			<c:forEach var="allsong" items="${AllSongs}">
				<div class="m-4" style="width: 200px;">
					<div style="position: relative;">
						<img src="images/04.jpg" class="big-song-img rounded img-fluid" >
						<a href="#">
							<div class="big-song-hover " >
								<i class="h1 bi bi-play"></i>
							</div>
						</a>
						</div>
					<div>
						<div class="lead text-white">${allsong.name}</div>
						<small class="text-muted">${allsong.description}</small>
					</div>
					<div>
						<form method="post" action="UploadLibararySevlet">
							<input type="hidden" name="sid" value="${allsong.sid}"/>
							<input type="submit" value="Add to Library" class="btn btn-outline-info"/>
						</form>
						
					</div>
					
				</div>
			</c:forEach>
			<!--song card end-->

		</section>
		<!-- end category area-->

		
	</main><!--end main area-->

	<footer class="p-5 pt-4  row bg-dark text-white">
		
		<div class="col-md-3 mb-4 col-sm-6">
			<h5>Quick links</h5>
			<ul class="nav flex-column">
				<li><a href="#">Home</a></li>
				<li><a href="#">Latest</a></li>
				<li><a href="#">Signup</a></li>
				<li><a href="#">Login</a></li>
			</ul>
		</div>
		<div class="col-md-3 mb-4 col-sm-6">
			<h5>Quick links</h5>
			<ul class="nav flex-column">
				<li><a href="#">Featured</a></li>
				<li><a href="#">New releases</a></li>
				<li><a href="#">Signup</a></li>
				<li><a href="#">Login</a></li>
			</ul>
		</div>
		<div class="col-md-6 mb-4">
			<h5>Subscribe to our newsletter</h5>
			<div>to receive news content</div>

			<div class="input-group mb-3 mt-2">
			  <input type="text" class="form-control" placeholder="Email" >
			  <span class="bg-primary text-white input-group-text" id="basic-addon2">Subscribe</span>
			</div>

			<div class="text-white h5 ">
				Follow us: 
				<a href="">
					<i class="bi bi-facebook"></i>
				</a>
				<a href="">
					<i class="bi bi-twitter"></i>
				</a>
				<a href="">
					<i class="bi bi-instagram"></i>
				</a>
			</div>

		</div>
	</footer>
</body>

<script src="js/bootstrap.min.js"></script>
</html>