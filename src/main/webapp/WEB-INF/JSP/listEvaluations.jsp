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
	<div class="h1 text-left my-4">List of Evaluations</div>

	<table class="table table-striped table-border">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Reviewer Email</th>
				<th scope="col">Interview Date</th>
				<th scope="col">Interview Time</th>
				<th scope="col">Rating</th>
				<th scope="col">Operations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${evaluations}' var="evaluation">
				<tr>
					<td>${evaluation.getId() }</td>
					<td>${evaluation.getReviewerEmail() }</td>
					<td>
					${evaluation.getInterviewDate().getDate()} ${evaluation.getInterviewDate().getMonth() } ${evaluation.getInterviewDate().getYear() }
					</td>
					<td>
					${evaluation.getInterviewDate().getHours() }:${evaluation.getInterviewDate().getMinutes() }
					</td>
					<td>${evaluation.getRating()}</td>
					<td>
						<a class="btn btn-primary" href="/getProfile/${profile.getId()}">View</a>
						<a class="btn btn-info" href="/updateProfile/${profile.getId()}">Edit</a>
						<a class="btn btn-danger" href="/deleteProfile/${profile.getId()}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</div>
</div>
</div>

</body>
</html>