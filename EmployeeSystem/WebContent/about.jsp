<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee System</title>
</head>
<body>

   <h1>About Us</h1>
    
    <c:forEach var="item" items="${aboutList}">
        <h2>${item.sectionTitle}</h2>
        <p>${item.description}</p>
        <hr/>
    </c:forEach>
    
</body>
</html>