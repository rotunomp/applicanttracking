<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="partials/dependencies.jsp"></jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"></jsp:include>

<div class="container">
<div class="row d-flex justify-content-center">
<div class="column">

	<div class="h1 text-center my-4">Update profile</div>
	
	<form action="addProfile" method="post" enctype="multipart/form-data">
	
		<div class="input-group form-group">
		  <div class="input-group-prepend">
		    <span class="input-group-text">Name</span>
		  </div>
		  <input type="text" class="form-control mr-1" name="firstName" placeholder="First name" value='${profile.getFirstName() }'>
		  <input type="text" class="form-control" name="lastName" placeholder="Last name">
		</div>
	
	    <div class="form-group">
	      <label>Email</label>
	      <input type="email" class="form-control" placeholder="Enter email" name="email">
	    </div>
	    
		<label>Upload Resume</label>    
		<div class="custom-file mb-3">
		  <input type="file" class="custom-file-input" id="customFile" name="resume">
		  <label class="custom-file-label">Choose file</label>
		</div>
	    
	    <div class="form-group">
	    	<input type="submit" class="btn btn-primary" value="Add Person">
	    </div>
	    
	    
	</form>

</div>
</div>
</div>
</body>
</html>