<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Update Terms</title>
</head>
<body>

	<section class="vh-100 gradient-custom">
	  <div class="container py-5 h-100">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
	        <div class="card bg-dark text-white" style="border-radius: 1rem;">
	          <div class="card-body p-5 text-center">
	
	            <div class="mb-md-5 mt-md-4 pb-5">
	
	              <h2 class="fw-bold mb-2 text-uppercase">Update Terms</h2>
	              
				<form method="post" action="UpdateTerms">
				
						<% 
						    String id = request.getParameter("id");
							String des = request.getParameter("des");
						%>  
							            
	              <div class="form-outline form-white mb-4">
	                <input type="text" readonly name="aid" id="typeEmailX" value="<%= id %>" class="form-control form-control-lg" />
	                <label class="form-label" for="typeEmailX">Id</label>
	              </div>
	              
	              <div class="form-outline">
					 <textarea class="form-control" name="area" id="textAreaExample1" rows="4" required><%= des %></textarea>
					 <label class="form-label" for="textAreaExample">Message</label>
				</div>
						
	      			<input class="btn btn-outline-light btn-lg px-5" type="submit" name="sid" value="Submit"/>
	      			<a href="http://localhost:8090/MusicStore/GetArtistsServlet"><button class="btn btn-outline-light btn-lg px-5"/>Back</button></a>
				</form>
	
	            </div>
	
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>

</body>
</html>