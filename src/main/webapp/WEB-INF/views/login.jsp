<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions" version="2.0">

	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Anton Banking Inc</title>
</head>
<body>
	<h1>Login</h1>	
	<form:form action="/auth/login" method="post" modelAttribute="user">
<table>
	<tr>
				<td><form:label path="name">First Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="*" /></td>
			</tr>
			<tr>
				<td><form:label path="password">User Password</form:label></td>
				<td><form:password path="password" /></td>				
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
	</tr>								
	</table>
</form:form>
</body>
	</html>
</jsp:root>