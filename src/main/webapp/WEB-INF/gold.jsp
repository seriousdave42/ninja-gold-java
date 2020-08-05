<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ninja Gold</title>
	<link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	<h2>Current Gold: <c:out value="${sessionScope.gold}" /></h2>
	
	<div class="row">
		<div class="col">
			<div class="card text-center">
				<h4 class="card-title">Farm</h4>
				<p class="card-text">(earns 10-20 gold)</p>
				<form action="/farm" method="POST">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="col">
			<div class="card text-center">
				<h4 class="card-title">Cave</h4>
				<p class="card-text">(earns 5-10 gold)</p>
				<form action="/cave" method="POST">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="col">
			<div class="card text-center">
				<h4 class="card-title">House</h4>
				<p class="card-text">(earns 2-5 gold)</p>
				<form action="/house" method="POST">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="col">
			<div class="card text-center">
				<h4 class="card-title">Casino!</h4>
				<p class="card-text">(earns/loses 0-50 gold)</p>
				<form action="/casino" method="POST">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="col">
			<div class="card text-center">
				<h4 class="card-title">Spa</h4>
				<p class="card-text">(loses 5-20 gold)</p>
				<form action="/spa" method="POST">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
	</div>
	
	<h2>Activity Log</h2>
	
	<ul style="height: 100px;" class="list-unstyled overflow-auto">
		<c:forEach var="message" items="${sessionScope.log}">
			<li class="${message.contains('lost') ? 'text-danger' : 'text-success'}"><c:out value="${message}"/></li>
		</c:forEach>
	</ul>
	
	<a class="btn btn-danger" href="/reset" role="button">Reset</a>
	</div>
	
	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>