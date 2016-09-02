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
	</form:form>
	<a href="/cert/home">Home</a>
</body>
</html>