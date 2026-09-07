<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Management System</title>
</head>
<body>

    <h1>Welcome to Login page please enter Credential! </h1>

    <div style="margin: 50px auto; width: 300px; text-align: center;">
      
        
        <%-- Display error message if authentication fails --%>
        <% 
            String errorMessage = (String)request.getAttribute("errorMessage");
            if (errorMessage != null) { 
        %>
            <p> <%=errorMessage %></p>
            <p style="color: red;">Invalid credential !</p>
               Error Code:  ${errorCode}
        <% 
        }   
       %>
   
        <h2>Employee Login Form</h2>     
        <form action="employeeLogin" method="post">
            <label>Employee Name:</label><br>
            <input type="text" name="empName" required><br><br>
            <label>Password:</label><br>
            <input type="password" name="password" required><br><br>
            <input type="submit" value="Employee Login">
        </form>
        
        <hr/>
        
        <h2>Admin Login Form</h2>     
        <form action="adminLogin" method="post">
            <label>Admin Name:</label><br>
            <input type="text" name="adminName" required><br><br>
            <label>Password:</label><br>
            <input type="password" name="adminPass" required><br><br>
            <input type="submit" value="Admin Login">
        </form>
        
        <hr>
        
        <h2>Guest Login Form</h2>     
        <form action="guestLogin" method="post">
            <label>Guest Name:</label><br>
            <input type="text" name="guestName" required><br><br>
            <label>Password:</label><br>
            <input type="password" name="guestPass" required><br><br>
            <input type="submit" value="Guest Login">
        </form>
        
    </div>
</body>
</html>