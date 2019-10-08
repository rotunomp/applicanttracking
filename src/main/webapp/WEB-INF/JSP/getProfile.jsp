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

	<div class="h1 text-center my-4">Profile</div>
	
	<form action="getProfile" method="get" enctype="multipart/form-data">
	
		<div class="input-group form-group">
		  <div class="input-group-prepend">
		    <span class="input-group-text">Name</span>
		  </div>
		  <input type="text" class="form-control mr-1" name="firstName" value='${profile.getFirstName() } ' readonly>
		  <input type="text" class="form-control" name="lastName" value = ${profile.getLastName() } readonly>
		</div>
	
	    <div class="form-group">
	      <label>Email</label>
	      <input type="email" class="form-control" placeholder="Enter email" name="email" value = ${profile.getEmail() } readonly>
	    </div>
	    
		<label>Upload Resume</label>    
		<div class="custom-file mb-3">
		  <input type="file" class="custom-file-input" id="customFile" name="resume" readonly>
		  <label class="custom-file-label">Choose file</label>
		</div>
	    
	</form>
	
</div>
</div>
</div>
</body>
</html>