<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee System</title>
</head>

<style>
div{
margin: 50px auto; 
width: 300px; 
text-align: center;
}
</style>

<body>
<h2>Welcome to Login page please enter your credential</h2>
<br/>

     <p style="color:red;">
        <%= request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage") %>
     </p> 

<h3>Employee Login Form</h3>
     <form action="empLoginServlet" method="post">  
      EmpName:<input type="text" name="empName"/><br/><br/>  
      Password:<input type="password" name="password"/><br/><br/>  
      <input type="submit" value="Employee Login"/>
    </form>
<hr>

<h3>Admin Login Form</h3>  
    <form action="adminLoginServlet" method="post">  
     AdminName:<input type="text" name="adminName"/><br/><br/>  
     Password:<input type="password" name="adminPass"/><br/><br/>  
     <input type="submit" value="Admin Login"/>
</form>


</body>
</html>