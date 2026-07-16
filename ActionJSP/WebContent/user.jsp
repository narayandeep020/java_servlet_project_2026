<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>

<jsp:useBean id="u" class="com.example.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
Record:<br>  
<jsp:getProperty property="name" name="u"/><br>  
<jsp:getProperty property="password" name="u"/><br>  
<jsp:getProperty property="email" name="u" /><br> <br/> 

<a href="printable.jsp">index page</a>

</body>
</html>