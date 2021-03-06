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
	<a href="/AntonBanking/AdminServlet">Back to list of users</a>
	<form method="get" action="AddAccountServlet">
		<input type="submit" value="Add Account" />		
		<input type="text" name="ATMQuantity" />		
		<SELECT name="CurrencyTypes" >
			<c:forEach items="${ATMCurrencyTypes}" var="CurrencyType">
				<option value="${CurrencyType}">${CurrencyType}</option>
			</c:forEach>
		</SELECT>		
	</form>	
	<form method="GET" action="AccountsServlet">
	<h1 align="center">List of Accounts for <c:out value="${ATMUserName}" /></h1>	
	<table id="AccountsList" cellspacing="0" cellpadding="0" border="1" align="center" >
		<thead>
			<tr>
				<th>Type</th>
				<th>Quantity</th>
			</tr>			
		</thead>
		<TBODY>
			<c:forEach items="${ATMAccounts}" var="account">
				<tr>					
					<td><a href="/AntonBanking/MyTransactionServlet?ATMUserID=${ATMUserID}&amp;ATMAccountID=${account.idstr}"> <c:out value="${account.typstr}" /> </a></td>
					<td><c:out value="${account.qanstr}" /></td>				
				</tr>
			</c:forEach>
		</TBODY>
	</table>	
	</form>
</body>
	</html>
	</jsp:root>