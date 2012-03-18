<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jstl/core_rt"
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
	<a href="/AntonBanking">Back to list of users</a>
	<form method="post" action="AddAccountServlet">	
		<table>
			<tr>
				<td><form:label path="account.quantity">Quantity</form:label></td>
				<td><form:input path="account.quantity" /></td>
			</tr>
			<tr>
				<td><form:label path="account.typ">Currency Type</form:label></td>
				<td><form:select path="account.typ">
						<form:option label="Select one ..." value="" />
						<form:options items="${ATMCurrencyTypes}" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Account" /></td>
			</tr>
		</table>
	</form>

	<DIV>
		<h1 align="center">
			List of Accounts
			<c:out value="${ATMUserName}" />
		</h1>
		<table id="AccountsList" cellspacing="0" cellpadding="0" border="1"
			align="center">
			<thead>
				<tr>
					<th>Type</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<TBODY>
				<c:forEach items="${ATMAccounts}" var="account">
					<tr>
						<td><a
							href="/AntonBanking/MyTransactionServlet/${HiddenUserID}/${account.acc_id}">
								<c:out value="${account.typ}" />
						</a></td>
						<td><c:out value="${account.quantity}" /></td>
					</tr>
				</c:forEach>
			</TBODY>
		</table>
	</DIV>
</body>
	</html>
</jsp:root>