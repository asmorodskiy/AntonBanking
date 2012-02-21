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
	<a href="/AntonBanking/AccountsServlet?ATMUserID=${ATMUserID}">Back to list of accounts for ${ATMUserName}</a>
	<c:if test="${error != null }">
	<h1 size="23" color="red"> Shit happens </h1>	
	</c:if>
	<form method="get" action="AddMyTransactionServlet">
		<input type="submit" value="Add Money" />				
		<input type="text" name="valplus" />
	</form>
	<form method="get" action="AddMyTransactionServlet">
		<input type="submit" value="Take Money" />				
		<input type="text" name="valminus" />
	</form>		
	<form method="GET" action="MyTransactionServlet">
	<h1 align="center">List of Transactions for <c:out value="${ATMUserName}" /> currency=<c:out value="${ATMCurrencyName}" /></h1>	
	<table id="MyTransactionsList" cellspacing="0" cellpadding="0" border="1" align="center" >
		<thead>
			<tr>
				<th>Date</th>
				<th>Value</th>
			</tr>			
		</thead>
		<TBODY>
			<c:forEach items="${ATMTransactions}" var="transaction">
				<tr>					
					<td><c:out value="${transaction.datestr}" /></td>
					<td><c:out value="${transaction.valuestr}" /></td>				
				</tr>
			</c:forEach>
		</TBODY>
	</table>	
	</form>
</body>
	</html>
	</jsp:root>