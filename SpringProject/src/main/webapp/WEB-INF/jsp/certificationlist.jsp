<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${certficationList}" var="item">
		<table border="1">
			<tr>
				<td><c:out value="${item.certName}" /> 
				<td><c:out value="${item.version}" /></td>
				<td><c:out value="${item.module}" /></td>
				<td><c:out value="${item.availableSince}" /></td>
				<td><c:out value="${item.gwCenter}" /></td>
				<td><a href="/cert/remove-cert/<c:out value="${item.certID}"/>"> Delete</a></td>
				<form:form method="delete" action="/certificates/${item.certID}">
					<td><input type="submit" value="Delete Rest"/></td>
				</form:form>
				<form:form method="delete" action="/certificates/delete/${item.certID}">
					<td><input type="submit" value="Delete Rest Object"/></td>
				</form:form>
				</tr>
		</table>
	</c:forEach>
<<<<<<< HEAD
	<a href="/cert/home">Home</a>
=======
	<a href="/spring/cert/home">Back</a>
>>>>>>> branch 'master' of https://github.com/sujittripathy/spring-projects.git
</body>
</html>