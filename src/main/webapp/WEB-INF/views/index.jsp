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
	<c:if test="${error != null }">
		<h1 size="23" color="red">Shit happens</h1>
	</c:if>
	<form:form method="post" action="AddUser" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="name">First Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="*" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add User" /></td>
			</tr>
		</table>
	</form:form>
	<DIV>
		<h1 align="center">List of Users</h1>
		<table id="UserList" cellspacing="0" cellpadding="0" border="1"
			align="center">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
				</tr>
			</thead>
			<TBODY>
				<c:forEach items="${ATMUsers}" var="user">
					<tr>
						<td><a
							href="/AntonBanking/AccountsServlet/${user.userID}"><c:out
									value="${user.userID}" /></a></td>
						<td><c:out value="${user.name}" /></td>
					</tr>
				</c:forEach>
			</TBODY>
		</table>
	</DIV>
</body>
	</html>
</jsp:root>