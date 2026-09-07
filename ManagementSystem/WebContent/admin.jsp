<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.management.dto.AdminDTO"%>
<%@ page import="java.io.IOException"%>

    <jsp:include page="header.jsp" />
    
    <h1>Welcome to Admin page</h1>

 <%-- Display message --%>
        <% 
            String insertMessage = (String)session.getAttribute("insertMessage");
            if (insertMessage != null) { 
        %>
            <p> <%=insertMessage %></p>
        <% 
        }   
       %>
       
         <% 
            String updateMessage = (String)session.getAttribute("updateMessage");
            if (updateMessage != null) { 
        %>
            <p> <%=updateMessage %></p>
        <% 
        }   
       %>
       
          <% 
            String deleteMessage = (String)session.getAttribute("deleteMessage");
            if (deleteMessage != null) { 
        %>
            <p> <%=deleteMessage %></p>
        <% 
        }   
       %>
       
  <a href="createAdmin">Add New Admin</a>
     <% 
            String createAdmin = (String)session.getAttribute("createAdmin");
            if (createAdmin != null) { 
        %>
<form action="saveAdmin" method="post">
	<table>
		<tr>
			<td><input type='hidden' name='adminId' value='-1' />
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="adminName" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="adminPass" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="adminEmail" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><select name="country" style="width: 150px">
					<option>India</option>
					<option>USA</option>
					<option>UK</option>
					<option>Other</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save Admin" /></td>
		</tr>
	</table>
</form>
  <% 
        }   
       %>
<br/>
<br/>
       
 <a href="admin">View All Admin</a>
<%
List<AdminDTO> list = (List<AdminDTO>) session.getAttribute("adminList");
      if (list != null) { 
%>

 <p>Raw Admin List Data: ${adminList}</p>
  
<table border='1' >
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Country</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<%
	for (AdminDTO e : list) {
	%>
	<tr>
		<td><%=e.getAdminId() %></td>
		<td><%=e.getAdminName() %></td>
		<td><%=e.getAdminEmail() %></td>
		<td><%= e.getCountry()%></td>
		<!-- Form uses POST because HTML doesn't natively support PUT -->
		<td><form action='editAdmin' method='post'>
				<!-- Hidden input to flag this as a PUT operation -->
				<input type='hidden' name='_method' value='PUT'>
				<input type='hidden' name='editAdminId' value='<%= e.getAdminId()%>' />
				<button type='submit'>Edit</button>
			</form></td>
		<!-- Form uses POST because HTML doesn't natively support DELETE-->
		<td><form action='deleteAdmin' method='post'>
				<!-- Hidden input to flag this as a PUT operation -->
				<input type='hidden' name='_method' value='DELETE'>
				 <input type='hidden' name='deleteAdminId' value='<%= e.getAdminId()%>' />
				<button type='submit'>Delete</button>
			</form></td>
	</tr>
	<%
	 } // ends for loop
   }// ends if condition 
	%>
</table>
<br/>
<br/>
    
   <% 
   AdminDTO  editAdminObj=(AdminDTO)session.getAttribute("editAdminObj"); 
            if (editAdminObj != null) { 
        %>
<form action='updateAdmin' method='post'>
<table>
<tr><td></td><td><input type='hidden' name='editAdminId' value='<%=editAdminObj.getAdminId() %>'/></td></tr>
<tr><td>Name:</td><td><input type='text' name='adminName' value='<%=editAdminObj.getAdminName() %>'/></td></tr>
<tr><td>Password:</td><td><input type='password' name='adminPass' value='<%=editAdminObj.getAdminPass() %>'/></td></tr>
<tr><td>Email:</td><td><input type='email' name='adminEmail' value='<%=editAdminObj.getAdminEmail()%>'/></td></tr>
<tr><td>Country:</td><td>
<select name='country' style='width:150px'>
<option>India</option>
<option>USA</option>
<option>UK</option>
<option>Other</option>
</select>
</td></tr>
<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>
</table>
</form>
   <% 
       }   
     %>
<br/>
<br/>
       
<form action="viewByIdAdmin" method="get">
	<input type="number" name="viewAdminId"> <input type="submit"
		value="View Admin By Id">
</form>

<%-- Retrieve the object from the request scope and cast it --%>
   <% 
   AdminDTO  adminObjByID=(AdminDTO)session.getAttribute("adminObjByID"); 
            if (adminObjByID != null) { 
        %>
          <p>Raw Employee Object Data: ${empObjByID}</p>
   
    <div style="margin: 50px auto; width: 400px; text-align: center;">
			<table border='1'>
				<tr><td>Admin ID: </td><td>${adminObjByID.adminId}</td></tr> 
				<tr><td>Name:</td><td>${adminObjByID.adminName}</td></tr>
				<tr><td>Email:</td><td>${adminObjByID.adminEmail}</td></tr>
				<tr><td>Country:</td><td>${adminObjByID.country}<td></tr>   
			</table>  
    </div>
        <% 
        }   
       %>
<br/>
<br/>


<form action="viewByNameAdmin" method="get">
	<input type="text" name="viewAdminName"> <input type="submit"
		value="View Admin By Name">
</form>
<%
List<AdminDTO> adminSearchList = (List<AdminDTO>) session.getAttribute("adminSearchList");
      if (adminSearchList != null) { 
%>

 <p>Raw Employee List Data: ${empSearchList}</p>
 
 
<table border='1' >
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Country</th>
	</tr>
	<%
	for (AdminDTO admin : adminSearchList) {
	%>
	<tr>
		<td><%=admin.getAdminId() %></td>
		<td><%=admin.getAdminName() %></td>
		<td><%=admin.getAdminEmail() %></td>
		<td><%=admin.getCountry()%></td>
	</tr>
	<%
	 } // ends for loop
   }// ends if condition 
	%>
</table>


<br />
<br />
<a href="/ManagementSystem/displayImageA">View Image</a>


<!-- Step 3: Inject the common footer -->
<jsp:include page="footer.jsp" />