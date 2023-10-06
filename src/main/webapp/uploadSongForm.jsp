<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

	<section class="vh-100 bg-image"
	  style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
	  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
	    <div class="container h-100">
	      <div class="row d-flex justify-content-center align-items-center h-100">
	        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
	          <div class="card" style="border-radius: 15px;">
	            <div class="card-body p-5">
	              <h2 class="text-uppercase text-center mb-5">Upload Song</h2>
	
	              <form action="UploadMusicServlet" method="post">
	
	                <div class="form-outline mb-4">
	                  <input type="text" id="form3Example1cg" name="name" class="form-control form-control-lg" />
	                  <label class="form-label" for="form3Example1cg">Enter song name</label>
	                </div>
	
	                <div class="form-outline mb-4">
	                  <input type="text" id="form3Example3cg" name="category" class="form-control form-control-lg" />
	                  <label class="form-label" for="form3Example3cg">Enter category</label>
	                </div>
	                
	                <div class="mb-3">
					  <label for="exampleFormControlTextarea1" class="form-label">Description</label>
					  <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3"></textarea>
					</div>	
	
	                <div class="d-flex justify-content-center">
	                  <input type="submit" value="submit"
	                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body"/>
	                </div>

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