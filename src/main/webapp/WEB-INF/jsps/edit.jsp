<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<h1>Edit Customer</h1>
		<s:form modelAttribute="customer" action="addProcess">
		
		<s:hidden path="id"/>
		
		Customer Name:<s:input path="cust_id" /><br/>
		
		Email:<s:input path="cust_email" /><br/>
		
		Password:<s:input path="cust_pw" /><br/>
		
		Phone:<s:input path="cust_phone" /><br/>
		
		Country:<s:select path="country">
			<s:option value="India">India</s:option>
			<s:option value="Indonesia">Indonesia</s:option>
			<s:option value="China">China</s:option>
		</s:select>
		<br/>
		
		<input type="submit" value="Save Data"/>
	</s:form>
	
</body>
</html>