<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language JSP</title>
</head>
<body>
<h3>Welcome to request page</h3>
<form action="process.jsp">  
Enter Name:<input type="text" name="name" /><br/><br/>  
<input type="submit" value="go"/>  
</form> 

<br/>

<h3>welcome to session page</h3>  
<%  
session.setAttribute("user","sonoo");  
%>  
  
<a href="process.jsp">visit</a>

<br/>

<h3>welcome to cookies page</h3>
<% Cookie ck = new Cookie("name1","Satyam");
response.addCookie(ck);
%>

<a href="process.jsp">cookie</a>
<br/><br/>

<p>Arithmetic Operators</p>
Plus: ${10 + 25}   <!-- Output: 35 -->
<br/>
Divide: ${20 / 4 } <!-- Output: 5 -->
<br/>
Modulus: ${7 mod 3}  <!-- Output: 1 --> 
<br/>

<p>Relational Operators</p>
${10 eq 10}   <!-- Output: true -->
<br/>
${5 lt 3}     <!-- Output: false -->
<br/>
<% request.setAttribute("price", "101"); %>
${price ge 100} <!-- true if price >= 100 -->
<br/>

<p>Logical Operators</p>
${(5 gt 3) and (10 lt 20)} <!-- Output: true -->
<br/>
${not (5 eq 5)}            <!-- Output: false -->
<br/>

<p>Conditional Operators</p>
<% request.setAttribute("score", "75"); %>
${(score gt 50) ? "Pass" : "Fail"}
<br/>
<% request.setAttribute("userName", "Deep");%>
<p>Welcome, ${empty userName ? "Guest" : userName}</p>

</body>
</html>