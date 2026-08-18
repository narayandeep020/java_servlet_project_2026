<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.emp.system.bean.EmpLoginBean" %>
 <%@ page import="com.emp.system.bean.AdminLoginBean" %>


<jsp:include page="header.jsp" />

<h1>Welcome to home page</h1><br/>
<br/>
<p>You have successfully logged in.</p>
<hr>
    
 <% 
 EmpLoginBean  empData = (EmpLoginBean)session.getAttribute("empObj"); 
    if (empData != null) { 
  %>
          <p>Raw Employee Object Data: ${empObj}</p>
 
     <div style="margin: 50px auto; width: 400px; text-align: center;">
        <h1>Welcome, <%= session.getAttribute("empName") %>!</h1>
         <!-- Displaying the entire object invokes its toString() method -->
       
        <h3>Employee Details using expression language:</h3>
			<table border='1'>
				<tr><td>Employee ID: </td><td>${empObj.empID}</td></tr> 
				<tr><td>Name:</td><td>${empObj.empName}</td></tr>
				<tr><td>Email:</td><td>${empObj.empEmail}</td></tr>
				<tr><td>Country:</td><td>${empObj.country}<td></tr>   
			</table>  
		</div>	
			
			
    <div style="margin: 50px auto; width: 400px; text-align: center;">
    <h3>Employee Details using expression tag:</h3>
			<table border='1'>
				<tr><td>Employee ID: </td><td><%= empData.getEmpID() %></td></tr> 
				<tr><td>Name:</td><td><%= empData.getEmpName() %></td></tr>
				<tr><td>Email:</td><td><%= empData.getEmpEmail() %></td></tr>
				<tr><td>Country:</td><td><%= empData.getCountry() %><td></tr>   
			</table>  
   </div>
    
        <% 
        }   
       %>
 <hr>
 
    <% 
   
   AdminLoginBean  adminData = (AdminLoginBean)session.getAttribute("adminObj"); 
            if (adminData != null) { 
   %>
          <p>Raw Admin Object Data: ${adminObj}</p>
 
  <div style="margin: 50px auto; width: 400px; text-align: center;">
        <h1>Welcome, <%= session.getAttribute("adminName") %>!</h1>
         <!-- Displaying the entire object invokes its toString() method -->
       
        <h3>Admin Details using expression language:</h3>
			<table border='1'>
				<tr><td>Admin ID: </td><td>${adminObj.adminId}</td></tr> 
				<tr><td>Name:</td><td>${adminObj.adminName}</td></tr>
				<tr><td>Email:</td><td>${adminObj.adminEmail}</td></tr>
				<tr><td>Country:</td><td>${adminObj.country}<td></tr>   
			</table>  
    </div>
    

<div style="margin: 50px auto; width: 400px; text-align: center;">
    <h3>Admin Details using expression tag:</h3>
			<table border='1'>
				<tr><td>Employee ID: </td><td><%= adminData.getAdminId() %></td></tr> 
				<tr><td>Name:</td><td><%= adminData.getAdminName() %></td></tr>
				<tr><td>Email:</td><td><%= adminData.getAdminEmail() %></td></tr>
				<tr><td>Country:</td><td><%= adminData.getCountry() %><td></tr>   
			</table>  
</div>
    
          
          
        <% 
        }   
       %>
 
<jsp:include page="footer.jsp" />