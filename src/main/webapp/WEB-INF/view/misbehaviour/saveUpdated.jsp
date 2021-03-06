<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Users</title>

<!-- Bootstrap -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Misbehaviours app</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url value="/misbehaviours" />"
						title="View Users">View misbehaviours</a></li>
					<li><a href="<s:url value="/users/" />" title="View users">View
							users</a></li>
					<li class="active"><a href="<s:url value="/misbehaviours/new" />"
						title="New user">New misbehaviour</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Misbehaviour created</h1>
		</div>
		<div class="alert alert-success" role="alert">The following misbehaviour
			has been updated successfully</div>
		<table class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Date</th>
					<th>User</th>
					<th>Operations</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${misbehaviour.title}</td>
						<td>${misbehaviour.description}</td>
						<td>${misbehaviour.date}</td>
						<td>${misbehaviour.user.id}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy; 2015 Eugenia Pérez</p>
		</div>
	</footer>
</body>
</html>