<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Fill below details to add new certification to database</h2>
	<form:form action="/cert/add-new-cert-submit" modelAttribute="certificationForm">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="certName" type="text"/></td>
				<td><form:errors path="certName"/></td>
			</tr>
			<tr>
				<td>Version</td>
				<td><form:input path="version" type="text"/></td>
				<td><form:errors path="version"/></td>
			</tr>
			<tr>
				<td>Module</td>
				<td><form:input path="module" type="text"/></td>
				<td><form:errors path="module"/></td>
			</tr>
			<tr>
				<td>GW Center</td>
				<td><form:input path="gwCenter" type="text"/></td>
				<td><form:errors path="gwCenter"/></td>
			</tr>
			<tr>
				<td>Available Since</td>
				<td><form:input path="availableSince" type="text" /></td>
				<td><form:errors path="availableSince"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit Form"/>
	</form:form>
</body>
</html>