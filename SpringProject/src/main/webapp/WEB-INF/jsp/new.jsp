<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<html>
<head>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>
	<h1>New Person Record</h1>

	<form:form action="/temp/submit" method="POST" commandName="person">
		<table>
			<tr>
				<th>Name</th>
				<td><form:input path="name"/></td>
				<form:errors path="name" cssClass=".error"/>
			</tr>
			<tr>
				<th>Country</th>
				<td><form:input path="country"/></td>
				<form:errors path="country" cssClass=".error"/>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>