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

	<div class="h1 text-center my-4">Add an evaluation</div>
	
	<form action="addEvaluation" method="post">
		
	    <div class="form-group">
	      <label>Reviewer Email</label>
	      <input type="email" class="form-control" placeholder="Enter email" name="reviewerEmail">
	    </div>
	    	    	    
	    <div class="form-group">
	    	<input type="submit" class="btn btn-primary" value="Add Evaluation">
	    </div>
	    
	    
	</form>
	
</div>
</div>
</div>
</body>
</html>