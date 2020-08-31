<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h1>Add Employee</h1>
		<s:form modelAttribute="customer" action="register">
		
		Customer Name:<s:input path="cust_name" /><br/>
		
		Email:<s:input path="cust_email" /><br/>
		
		Password:<s:input path="cust_pw" /><br/>
		
		Phone:<s:input path="cust_phone" /><br/>
		
		Country:<s:select path="cust_country">
			<s:option value="India">India</s:option>
			<s:option value="Indonesia">Indonesia</s:option>
			<s:option value="China">China</s:option>
		</s:select>
		<br/>
		
		<input type="submit" value="Register"/>
	</s:form>
	<a href="login">Login</a>
</body>
</html>