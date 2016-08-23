<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<html>
<body>
	<h1>New Person Record</h1>
	<h2>Status : ${status}</h2>
	<form:form modelAttribute="person" action="/temp/submit">
		<table>
			<tr>
				<th>Name</th>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<th>Country</th>
				<td><form:input path="country"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
			
		</table>
	</form:form>
</body>
</html>