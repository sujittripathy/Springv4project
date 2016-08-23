<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Record</title>
</head>
<body>
	<sf:form method="POST" modelAttribute="person" commandName="temp">
		<table>
			<tr>
				<th>Name</th>
				<td><sf:input path="name" size="30" id="name"/></td>
			</tr>
			<tr>
				<th>Country</th>
				<td><sf:input path="country" size="30" id="country"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit"/></td>
			</tr>
			
		</table>
	</sf:form>
</body>
</html>