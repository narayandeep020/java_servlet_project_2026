<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.management.dto.EmployeeDTO"%>
<%@ page import="java.io.IOException"%>
    
    <jsp:include page="header.jsp" />
    
    <h1>Welcome to Employee page</h1>

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
    
    
   <a href="createEmployee">Add New Employee</a>
     <% 
            String createEmployee = (String)session.getAttribute("createEmployee");
            if (createEmployee != null) { 
        %>
<form action="saveEmployee" method="post">
	<table>
		<tr>
			<td><input type='hidden' name='empId' value='-1' />
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="empName" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="empEmail" /></td>
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
			<td colspan="2"><input type="submit" value="Save Employee" /></td>
		</tr>
	</table>
</form>
  <% 
        }   
       %>
<br/>
<br/>

<a href="employee">View All Employees</a>
<%
List<EmployeeDTO> list = (List<EmployeeDTO>) session.getAttribute("empList");
      if (list != null) { 
%>

 <p>Raw Employee List Data: ${empList}</p>
  
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
	for (EmployeeDTO e : list) {
	%>
	<tr>
		<td><%=e.getEmpId() %></td>
		<td><%=e.getEmpName() %></td>
		<td><%=e.getEmpEmail() %></td>
		<td><%= e.getCountry()%></td>
		<!-- Form uses POST because HTML doesn't natively support PUT -->
		<td><form action='editEmployee' method='post'>
				<!-- Hidden input to flag this as a PUT operation -->
				<input type='hidden' name='_method' value='PUT'>
				<input type='hidden' name='editEmpId' value='<%= e.getEmpId()%>' />
				<button type='submit'>Edit</button>
			</form></td>
		<!-- Form uses POST because HTML doesn't natively support DELETE-->
		<td><form action='deleteEmployee' method='post'>
				<!-- Hidden input to flag this as a PUT operation -->
				<input type='hidden' name='_method' value='DELETE'>
				 <input type='hidden' name='deleteEmpId' value='<%= e.getEmpId()%>' />
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
   EmployeeDTO  editEmpObj=(EmployeeDTO)session.getAttribute("editEmpObj"); 
            if (editEmpObj != null) { 
        %>
<form action='updateEmployee' method='post'>
<table>
<tr><td></td><td><input type='hidden' name='editEmpId' value='<%=editEmpObj.getEmpId() %>'/></td></tr>
<tr><td>Name:</td><td><input type='text' name='empName' value='<%=editEmpObj.getEmpName() %>'/></td></tr>
<tr><td>Password:</td><td><input type='password' name='password' value='<%=editEmpObj.getPassword() %>'/></td></tr>
<tr><td>Email:</td><td><input type='email' name='mailId' value='<%=editEmpObj.getEmpEmail()%>'/></td></tr>
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


<form action="viewById" method="get">
	<input type="number" name="viewEmpId"> <input type="submit"
		value="View Employee By Id">
</form>

<%-- Retrieve the object from the request scope and cast it --%>
   <% 
   EmployeeDTO  empObjByID=(EmployeeDTO)session.getAttribute("empObjByID"); 
            if (empObjByID != null) { 
        %>
          <p>Raw Employee Object Data: ${empObjByID}</p>
   
    <div style="margin: 50px auto; width: 400px; text-align: center;">
			<table border='1'>
				<tr><td>Employee ID: </td><td>${empObjByID.empId}</td></tr> 
				<tr><td>Name:</td><td>${empObjByID.empName}</td></tr>
				<tr><td>Email:</td><td>${empObjByID.empEmail}</td></tr>
				<tr><td>Country:</td><td>${empObjByID.country}<td></tr>   
			</table>  
    </div>
        <% 
        }   
       %>
<br/>
<br/>


<form action="viewByName" method="get">
	<input type="text" name="viewEmpName"> <input type="submit"
		value="View Employee By Name">
</form>
<%
List<EmployeeDTO> empSearchList = (List<EmployeeDTO>) session.getAttribute("empSearchList");
      if (empSearchList != null) { 
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
	for (EmployeeDTO emp : empSearchList) {
	%>
	<tr>
		<td><%=emp.getEmpId() %></td>
		<td><%=emp.getEmpName() %></td>
		<td><%=emp.getEmpEmail() %></td>
		<td><%=emp.getCountry()%></td>
	</tr>
	<%
	 } // ends for loop
   }// ends if condition 
	%>
</table>


<br />
<br />
<a href="/ManagementSystem/displayImage">View Image</a>


<!-- Step 3: Inject the common footer -->
<jsp:include page="footer.jsp" />