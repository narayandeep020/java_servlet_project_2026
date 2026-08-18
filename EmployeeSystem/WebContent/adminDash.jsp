<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.emp.system.bean.AdminLoginBean" %>
<%@ page import="java.util.List" %>
   
    
<jsp:include page="header.jsp" />

   <h1>Welcome to Admin page</h1>
   
   <% String insertMessage = (String)session.getAttribute("insertMessage");
      if(insertMessage != null){ 
   %>
  <p> <%= insertMessage %> </p>
  <% } %>
  
  
  <% String updateMessage = (String)session.getAttribute("updateMessage");
     if( updateMessage != null){
  %>
  <p> <%= updateMessage %> </p>
   <% } %>
   
   
   <% String deleteMessage = (String)session.getAttribute("deleteMessage");
      if(deleteMessage != null){
   %>
   <p><%= deleteMessage %></p>
   <% } %>
   

<a href="createAdmin">Add New Admin</a>
<% String createAdmin = (String)session.getAttribute("createAdmin");
   if(createAdmin != null){
%>

<form action="saveAdmin" method="post">  
<table>  
<tr><td><input type='hidden' name='adminId' value='-1'/></tr>
<tr><td>Name:</td><td><input type="text" name="adminName"/></td></tr>  
<tr><td>Password:</td><td><input type="password" name="adminPass"/></td></tr>  
<tr><td>Email:</td><td><input type="email" name="adminEmail"/></td></tr>  
<tr><td>Country:</td><td>  
<select name="country" style="width:150px">  
<option>India</option>  
<option>USA</option>  
<option>UK</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Save Admin"/></td></tr>  
</table>  
</form>  
<% } %>

 <br/>
 <br/>   
   
<a href="admin">View All Admin</a>
 <%
    List<AdminLoginBean> list = (List<AdminLoginBean>) request.getAttribute("adminList");
    if(list != null){
%>

<p>Raw Admin List Data: ${adminList}</p>

    <table border="1" width="100%">
        <tr>
            <th>Id</th><th>Name</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th>
        </tr>
        <% 
        for(AdminLoginBean al : list){ 
        %>
            <tr>
                <td><%= al.getAdminId() %></td>
                <td><%= al.getAdminName() %></td>
                <td><%= al.getAdminEmail() %></td>
                <td><%= al.getCountry() %></td>
                <td>
                    <form action="editAdmin" method="post">
                        <input type="hidden" name="_method" value="PUT"/>
                        <input type="hidden" name="editAdminId" value="<%= al.getAdminId() %>"/>
                        <button type="submit">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="deleteAdmin" method="post">
                        <input type="hidden" name="_method" value="DELETE"/>
                        <input type="hidden" name="deleteAdminId" value="<%= al.getAdminId() %>"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
   <%    } 
    }
        %>
    </table>
<br/>
<br/>

         
  <% AdminLoginBean editObj = (AdminLoginBean)session.getAttribute("editAdmin"); 
    if(editObj != null){
 %>
    <form action="updateAdmin" method="post">
        <table>
            <tr><td></td><td><input type="hidden" name="editAdminId" value="<%= editObj.getAdminId() %>"/></td></tr>
            
            <tr><td>Name:</td><td><input type="text" name="adminName" value="<%= editObj.getAdminName() %>"/></td></tr>
            
            <tr><td>Password:</td><td><input type="password" name="adminPass" value="<%= editObj.getAdminPass() %>"/></td></tr>
            
            <tr><td>Email:</td><td><input type="email" name="adminEmail" value="<%= editObj.getAdminEmail() %>"/></td></tr>
            
            <tr><tr><td>Country:</td><td> 
		    <select name='country' style='width:150px'>  
		        <option>India</option>  
		        <option>USA</option> 
		        <option>UK</option>  
		        <option>Other</option>  
		     </select>
                </td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="Edit & Save"/></td></tr>
        </table>
    </form>
 <% } %>

<br/>
<br/>

		<form action="viewById" method="get">
			<input type="number" name="viewAdminId"> 
			<input type="submit" value="View Admin By Id">
		</form>
		<% AdminLoginBean adminObjById = (AdminLoginBean)session.getAttribute("adminById");
		   if(adminObjById != null){
		%>
		<p>Raw Admin Object Data: ${adminObjById}</p>
		
	<div style="margin: 50px auto; width: 400px; text-align: center;">
		<table border="1">
		   <tr><td>Admin ID:</td><td>${adminObjById.adminId}</td></tr>
		   <tr><td>Name:</td><td>${adminObjById.adminName}</td></tr>
		   <tr><td>Email:</td><td>${adminObjById.adminEmail}</td></tr>
		   <tr><td>Country:</td><td>${adminObjById.country}<td></tr> 
		</table>
	</div>
	<% } %>
		
<br/>
<br/>
		<form action="viewByName" method="get">
			<input type="text" name="viewAdminName"> 
			<input type="submit" value="View Admin By Name">
		</form>
		
		<% 
		List<AdminLoginBean> searchList = (List<AdminLoginBean>) session.getAttribute("adminList");
		   if(searchList != null){
		%>
		<p>Raw Employee Object Data: ${searchList}</p>
		
		<table border="1">
		<tr>
		   <th>Id</th>
		   <th>Name</th>
		   <th>Email</th>
		   <th>Country</th>
		</tr>
		<% 
		for(AdminLoginBean admin : searchList){
		%>
		<tr>
		<td><%=admin.getAdminId() %></td>
		<td><%=admin.getAdminName() %></td>
		<td><%=admin.getAdminEmail() %></td>
		<td><%=admin.getCountry()%></td>
	    </tr>
	    <% 
		}
		   }
	    %>
		</table>

<br/>
<br/>  
    <a href="/EmployeeSystem/displayImage">View Photo</a>
 

<jsp:include page="footer.jsp" />