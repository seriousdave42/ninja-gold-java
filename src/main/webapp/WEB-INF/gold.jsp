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
	<h2>Current Gold: <c:out value="${sessionScope.gold}" /></h2>
	<div class="row">
		<div class="col-3">
			<div class="card">
				<h4 class="card-title">Farm</h4>
				<p class="card-text">(earns 10-20 gold)</p>
				<form action="/gold" method="POST">
					<input type="hidden" name="turn" value="farm">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="col-3">
			<div class="card">
				<h4 class="card-title">Cave</h4>
				<p class="card-text">(earns 5-10 gold)</p>
				<form action="/gold" method="POST">
					<input type="hidden" name="turn" value="cave">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="col-3">
			<div class="card">
				<h4 class="card-title">House</h4>
				<p class="card-text">(earns 2-5 gold)</p>
				<form action="/gold" method="POST">
					<input type="hidden" name="turn" value="house">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="col-3">
			<div class="card">
				<h4 class="card-title">Casino!</h4>
				<p class="card-text">(earns/loses 0-50 gold)</p>
				<form action="/gold" method="POST">
					<input type="hidden" name="turn" value="casino">
					<button type="submit" class="btn btn-secondary">Find Gold!</button>
				</form>
			</div>
		</div>
	</div>
	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>