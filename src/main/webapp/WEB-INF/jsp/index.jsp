<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Task Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="home" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-emp">New Employee</a></li>
					<li><a href="all-emps">All Employees</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
	
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h3>Welcome to Employee Manager Portal</h3>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_EMPs'}">
			<div class="container text-center" id="empDiv">
				<h3>All Employee</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>FName</th>
								<th>MName</th>
								<th>LName</th>
								<th>Date</th>
								<th>Permanent</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="emp" items="${emps}">
								<tr>
									<td>${emp.id}</td>
									<td>${emp.FName}</td>
									<td>${emp.MName}</td>
									<td>${emp.LName}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${emp.date}"/></td>
									<td>${emp.type}</td>
									<td>
										<a href="update-emp?id=${emp.id}"><span class="glyphicon glyphicon-pencil"></span></a>
										&nbsp;<a href="delete-emp?id=${emp.id}"><span class="glyphicon glyphicon-trash"></span></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Employees</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-emp">
					<input type="hidden" name="id" value="${emp.id}"/>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="fName" value="${emp.FName}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Middle Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="mName" value="${emp.MName}"/>
						</div>				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lName" value="${emp.LName}"/>
						</div>				
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Permanent</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="type" value="true"/>
							<div class="col-sm-1">Yes</div>
							<input type="radio" class="col-sm-1" name="type" value="false" checked/>
							<div class="col-sm-1">No</div>
						</div>				
					</div>		
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
				</form>
			</div>		
		</c:when>
		
	</c:choose>
	
	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>

