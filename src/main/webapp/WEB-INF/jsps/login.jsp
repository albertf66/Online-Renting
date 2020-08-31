<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<s:form modelAttribute="customer" action="login">
		
		<s:hidden path="cust_id"/>
		
		Email:<s:input path="cust_email" /><br/>
		<s:errors path="cust_email" cssClass="error" /><br/>
		Password:<s:input path="cust_pw" /><br/>
		<s:errors path="cust_pw" cssClass="error" />
		
		<input type="submit" value="Login"/>
	</s:form>
</body>
</html>