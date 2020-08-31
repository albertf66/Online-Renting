<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer Lists</h1>
	<div>
		<table border="1">
			<tr>
				<th>Customer Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Phone</th>
				<th>Country</th>
				<th>Address</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${listofcustomers}" var="e">
				<c:url var="deleteLink" value="/deleteCustomer">
					<c:param name="customerId" value="${e.cust_id}" />
				</c:url>
				<c:url var="updateLink" value="/editCustomer">
					<c:param name="customerId" value="${e.cust_id}" />
				</c:url>
				<tr>
					<td>${e.cust_name}</td>
					<td>${e.cust_email}</td>
					<td>${e.cust_pw}</td>
					<td>${e.cust_phone}</td>
					<td>${e.cust_country}</td>
					<td><a href="${updateLink}">Update</a> 
					<a href="${deleteLink}" 
					onclick="if(!(confirm('Are you sure you want to delete '))) return false;">
					Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>