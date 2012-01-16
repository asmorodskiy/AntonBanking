<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jstl/core_rt"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	version="2.0">
	
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
	<form method="GET" action="AdminServlet">
	<H1><c:out value="${Test1}" /></H1>
	<table id="UserList" class="display" cellspacing="0" cellpadding="0"
		border="1">
		<thead>
			<tr>
				<th>tst</th>
				<th>Id</th>
				<th>Name</th>
			</tr>			
		</thead>
		<TBODY>
			<c:forEach items="${Users}" var="lst">
				<tr>
					<td>${Test1}</td>
					<td><c:out value="${lst.id}" /></td>
					<td><c:out value="${lst.name}" /></td>				
				</tr>
			</c:forEach>
		</TBODY>
	</table>	
	</form>
</body>
	</html>
	</jsp:root>