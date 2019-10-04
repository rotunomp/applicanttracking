<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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

	<div class="h1 text-center my-4">Evaluation</div>
	
	<form action="getEvaluation" method="get">
		
	    <div class="form-group">
	      <label>Reviewer Email</label>
	      <input type="email" class="form-control" placeholder="Enter email" name="reviewerEmail" value='${evaluation.getReviewerEmail() }' >
	    </div>
	    
	    <div class="form-group">
			<label>Date of Evaluation</label>
		    <input class="form-control"
								name="date" type="date" value='${evaluation.getInterviewDate() }'>
		</div>
		
		<div class="form-group">
			<label>Evaluation Start Time</label>
			<input type="time" name="time">
		</div>
		
		<div class="form-group">
			<label>Profile to be Evaluated</label>
			<select class="form-control" name="profile">
				<c:forEach items="${profiles}" var="profile">
					<option value='${evaluation.getProfile().getId()}'>${evaluation.getProfile().getFirstName() } ${profile.getLastName() }</option>
				</c:forEach>
			</select>
		</div>
	    
	    
	</form>
	
</div>
</div>
</div>
</body>
</html>