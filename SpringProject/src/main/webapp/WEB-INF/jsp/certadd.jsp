<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Fill below details to add new certification to database</h2>
<<<<<<< HEAD
	<form:form action="/cert/add-new-cert-submit" modelAttribute="certificationForm">
		
			<div>
				<label for="name">Name : </label>
				<form:input path="certName" type="text"/>
				<form:errors path="certName" cssStyle="color:red"/>
			</div>
			<div>
				<label for="version">Version : </label>
				<form:input path="version" type="text"/>
				<form:errors path="version" cssStyle="color:red"/>
			</div>
			<div>
				<label for="module">Module : </label>
				<form:input path="module" type="text"/>
				<form:errors path="module" cssStyle="color:red"/>
			</div>
			<div>
				<label for="center">GW Center : </label>
				<form:input path="gwCenter" type="text"/>
				<form:errors path="gwCenter" cssStyle="color:red"/>
			</div>
			<div>
				<label for="since">Available Since : </label>
				<form:input path="availableSince" type="date"/>
				<form:errors path="availableSince" cssStyle="color:red"/>
			</div>
		<div class="button">
			<input type="submit" value="Submit Form" />
		</div>
=======

	<form:form action="/spring/cert/add-new-cert-submit" modelAttribute="certificationForm">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="certName" type="text"/></td>
				<td><form:errors path="certName" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>Version</td>
				<td><form:input path="version" type="text"/></td>
				<td><form:errors path="version" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>Module</td>
				<td><form:input path="module" type="text"/></td>
				<td><form:errors path="module" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>GW Center</td>
				<td><form:input path="gwCenter" type="text"/></td>
				<td><form:errors path="gwCenter" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td>Available Since</td>
				<td><form:input path="availableSince" type="date"/></td>
				<td><form:errors path="availableSince" cssStyle="color:red"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit Form"/>
>>>>>>> branch 'master' of https://github.com/sujittripathy/spring-projects.git
	</form:form>
	<a href="/cert/home">Home</a>
</body>
</html>