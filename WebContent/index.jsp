<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IT2274 Hibernate Hello World Example</title>
<style>
table, th, tr, td{
	border:1px solid black;
}
</style>
</head>
<body>
	<h1>IT2274 Hibernate Hello World Example</h1>
	<h3>Student List</h3>
	<p>If you cannot see this list, please access the page <a href="StudentListServlet">here</a>.</p>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Admin No</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.adminNo}</td>
				<td>${student.age}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<hr/>
	<h3>Create Student</h3>
	<form method="post" action="StudentCreateServlet">
		<p>
			<label>Name: </label>
			<input type="text" name="s_name" />
		</p>
		<p>
			<label>Admin No: </label>
			<input type="text" name="s_admin_no" />
		</p>
		<p>
			<label>Age: </label>
			<input type="text" name="s_age" />
			<span> (non-empty and numeric only PLEASE!)</span>
		</p>
		<p>
			<input type="submit" value="Create" />
		</p>
	</form>
	<hr/>
	<h3>Update Student</h3>
	<p>Update record using Hibernate requires the primary key field (id) and the attribute values to be updated </p>
	<p>In order to demonstrate I designed this example to take in a literal id. In practice we should have a list of student implicitly hold the id value and let the users to choose from.</p>
	<form method="post" action="StudentUpdateServlet">
		<p>
			<label>Id:</label>
			<input type="text" name="s_id" />
			<span> (non-empty and numeric only PLEASE!)</span>
		</p>
		<p>
			<label>Name: </label>
			<input type="text" name="s_name" />
		</p>
		<p>
			<label>Admin No: </label>
			<input type="text" name="s_admin_no" />
		</p>
		<p>
			<label>Age: </label>
			<input type="text" name="s_age" />
			<span> (non-empty and numeric only PLEASE!)</span>
		</p>
		<p>
			<input type="submit" value="Update" />
		</p>
	</form>
	<hr/>
	<h3>Delete Student</h3>
	<p>Deleting record using Hibernate requires only the primary key field. In this case, the id. </p>
	<p>In order to demonstrate I designed this example to take in a literal id. In practice we should have a list of student implicitly hold the id value and let the users to choose from.</p>
	<form method="post" action="StudentDeleteServlet">
		<p>
			<label>Id: </label>
			<input type="text" name="s_id" />
			<span> (non-empty and numeric only PLEASE!)</span>
		</p>
		<p>
			<input type="submit" value="Delete" />
		</p>
	</form>
</body>
</html>