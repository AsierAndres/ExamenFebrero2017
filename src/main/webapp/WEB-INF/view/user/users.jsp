<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
				<a class="navbar-brand" href="#">Users app</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url value="/misbehaviours" />"
					title="<s:message code="navbar.misbehaviours"></s:message>"><s:message
							code="navbar.misbehaviours"></s:message></a></li>
					<li class="active"><a href="<s:url value="/users/" />"
						title="View users">View users</a></li>
					<li><a href="<s:url value="/users/new" />" title="New user">New
							user</a></li>
				</ul>
				
				
				<div class="nav navbar-nav navbar-right">
					<c:url var="post_search" value="/users/search" />
					<sf:form class="navbar-form" method="post"
						modelAttribute="searchUser" action="${post_search}">
						<div class="input-group">
							<sf:input path="login" class="form-control" placeholder="Search" />
							<div class="input-group-btn">s
								<sf:button class="btn btn-default" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</sf:button>
							</div>
						</div>
					</sf:form>
				</div>
			</div>
			
			<!--/.nav-collapse -->
		</div>
		
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Users list</h1>
			<p>These are the users currently in the system.</p>
			<p><a href="<s:url value="/misbehaviours" />">See misbehaviours</a></p>
		</div>

		<a class="btn btn-sm btn-danger" href="<s:url value="/users/deleteall" />" title="Delete"> DELETE ALL</a>
		<table class="table">
			<c:set var="login" value="login" />
			<c:set var="description" value="description" />
			<thead>
				<tr>
					<th><a href="<s:url value="/users/order/${login}"/>">Login</a></th>
					<th><a href="<s:url value="/users/order/${description}"/>">Description</a></th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.login}</td>
						<td>${user.description}</td>
						<td><a class="btn btn-sm btn-primary"
							href="<s:url value="/users/${user.id}" />"
							title="Detailed info"> see detail</a>
							<a class="btn btn-sm btn-success"
							href="<s:url value="/users/update/${user.id}" />"
							title="Update"> update</a>
							<a class="btn btn-sm btn-danger"
							href="<s:url value="/users/delete/${user.id}" />"
							title="Delete"> delete</a>
							</td>
					</tr>
				</c:forEach>
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