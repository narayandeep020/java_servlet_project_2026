<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<h3>jsp:forward action tag</h3>

<% out.println("Today is: "+ java.util.Calendar.getInstance().getTime()); %>
<br/>
<%= request.getParameter("name") %>
<br/>
<%= request.getParameter("id") %>
<br/>

<h3>jsp:include action tag</h3>
<%= "Taken time and date from index.jsp" %>
<br/>
<% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %> 
<br><hr> 

<h3>jsp:userBean action tag</h3>
<jsp:useBean id="user" class="com.example.UserDemo" scope="session"/>
<jsp:setProperty property="username" name="user" value="Deep Narayan"/>
<jsp:setProperty property="course" name="user" value="Java Developer"/>
<h2>Hello, <jsp:getProperty property="username" name="user"/>!</h2> 
<h2>Your course is: <jsp:getProperty property="course" name="user"/></h2>

<br><hr>

<form action="user.jsp" method="post">  
Name:<input type="text" name="name"><br>  
Password:<input type="password" name="password"><br>  
Email:<input type="text" name="email"><br>  
<input type="submit" value="register">  
</form>  

</body>
</html>