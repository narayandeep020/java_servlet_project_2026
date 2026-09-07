<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.management.dto.EmployeeDTO" %>
<%@ page import="com.management.dto.AdminDTO" %>
<%@ page import="com.management.dto.GuestDTO" %>

<jsp:include page="header.jsp" />

<h1>Welcome To Home Page</h1>
<p>You have successfully logged in.</p>

<hr>

<%-- Retrieve the object from the request scope and cast it --%>
 <%    
   EmployeeDTO  empData=(EmployeeDTO)session.getAttribute("empObj"); 
            if (empData != null) { 
 %>
       <p>Raw Employee Object Data: ${empObj}</p>
   
    <div style="margin: 50px auto; width: 400px; text-align: center;">
        <h1>Welcome, <%= session.getAttribute("empName") %>!</h1>
         <!-- Displaying the entire object invokes its toString() method -->
       
        <h3>Employee Details using expression language:</h3>
			<table border='1'>
				<tr><td>Employee ID: </td><td>${empObj.empId}</td></tr> 
				<tr><td>Name:</td><td>${empObj.empName}</td></tr>
				<tr><td>Email:</td><td>${empObj.empEmail}</td></tr>
				<tr><td>Country:</td><td>${empObj.country}<td></tr>   
			</table>  
    </div>
    

<div style="margin: 50px auto; width: 400px; text-align: center;">
    <h3>Employee Details using expression tag:</h3>
			<table border='1'>
				<tr><td>Employee ID: </td><td><%= empData.getEmpId() %></td></tr> 
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
   
   AdminDTO  adminData=(AdminDTO)session.getAttribute("adminObj"); 
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

<hr>

<% 
   GuestDTO  guestData=(GuestDTO)session.getAttribute("guestObj"); 
            if (guestData != null) { 
   %>
          <p>Raw Guest Object Data: ${guestObj}</p>
   
    <div style="margin: 50px auto; width: 400px; text-align: center;">
        <h1>Welcome, <%= session.getAttribute("guestName") %>!</h1>
         <!-- Displaying the entire object invokes its toString() method -->
       
        <h3>Guest Details using expression language:</h3>
			<table border='1'>
				<tr><td>Guest ID: </td><td>${guestObj.guestId}</td></tr> 
				<tr><td>Name:</td><td>${guestObj.guestName}</td></tr>
				<tr><td>Email:</td><td>${guestObj.guestEmail}</td></tr>
				<tr><td>Country:</td><td>${guestObj.country}<td></tr>   
			</table>  
    </div>
    

<div style="margin: 50px auto; width: 400px; text-align: center;">
    <h3>Guest Details using expression tag:</h3>
			<table border='1'>
				<tr><td>Guest ID: </td><td><%= guestData.getGuestId() %></td></tr> 
				<tr><td>Name:</td><td><%= guestData.getGuestName() %></td></tr>
				<tr><td>Email:</td><td><%= guestData.getGuestEmail() %></td></tr>
				<tr><td>Country:</td><td><%= guestData.getCountry() %><td></tr>   
			</table>  
</div>
    
          
          
<% 
        }   
%>

<jsp:include page="footer.jsp" />