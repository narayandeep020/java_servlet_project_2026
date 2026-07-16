<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag JSP</title>
</head>
<body>

<h2>This is index page</h2>
<jsp:forward page="printable.jsp">
<jsp:param value="javattech.com" name="name"/>
<jsp:param value="1011" name="id"/>
</jsp:forward>
<br/>

<h2>this is index page</h2>    
<jsp:include page="printable.jsp" />    
<h2>end section of index page</h2>  
<br/>


</body>
</html>