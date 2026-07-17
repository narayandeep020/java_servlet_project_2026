<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Welcome, ${ param.name }  
<br/>
Value is ${ sessionScope.user }  
<br/>
Hello, ${cookie.name1.value} 
 

</body>
</html>