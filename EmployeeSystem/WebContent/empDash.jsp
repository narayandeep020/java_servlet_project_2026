<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.emp.system.bean.EmpLoginBean" %>    
    
<jsp:include page="header.jsp" />

   <h1>Welcome to Employee page</h1>
   
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
   
<a href="/createEmployee">Add New Employee</a>
<% String createEmployee = (String)session.getAttribute("createEmployee");
   if(createEmployee != null){
%>

<form action="saveEmployee" method="post">  
<table>  
<tr><td><input type='hidden' name='empId' value='-1'/></tr>
<tr><td>Name:</td><td><input type="text" name="empName"/></td></tr>  
<tr><td>Password:</td><td><input type="password" name="password"/></td></tr>  
<tr><td>Email:</td><td><input type="email" name="empEmail"/></td></tr>  
<tr><td>Country:</td><td>  
<select name="country" style="width:150px">  
<option>India</option>  
<option>USA</option>  
<option>UK</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>  
</table>  
</form> 
<% } %>

<br/>  
<br/>
  
<a href="employee">View All Employees</a>  
<%
    List<EmpLoginBean> list = (List<EmpLoginBean>) request.getAttribute("empList");
    if(list != null){
%>
<p>Raw Employee List Data: ${employeeList}</p>

<table border="1" width="100%">
  <tr>
      <th>Id</th><th>Name</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th>
  </tr>
		<% 
		for(EmpLoginBean e: list) {
		%>
	 <tr>
           <td><%= e.getEmpID() %></td>
           <td><%= e.getEmpName() %></td>
           <td><%= e.getEmpEmail() %></td>
           <td><%= e.getCountry() %></td>
                <td>
                    <form action="editEmployee" method="post">
                        <input type="hidden" name="_method" value="PUT"/>
                        <input type="hidden" name="editEmpId" value="<%= e.getEmpID() %>"/>
                        <button type="submit">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="deleteEmployee" method="post">
                        <input type="hidden" name="_method" value="DELETE"/>
                        <input type="hidden" name="deleteEmpId" value="<%= e.getEmpID() %>"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
	</tr>
	<% }
		}%>
</table>

<br/>  
<br/>

 <% EmpLoginBean editObj = (EmpLoginBean)session.getAttribute("editEmpId"); 
    if(editObj != null){
 %>
    <form action="updateEmployee" method="post">
        <table>
            <tr><td></td><td><input type="hidden" name="editEmpId" value="<%= editObj.getEmpID() %>"/></td></tr>
            
            <tr><td>Name:</td><td><input type="text" name="empName" value="<%= editObj.getEmpName() %>"/></td></tr>
            
            <tr><td>Password:</td><td><input type="password" name="password" value="<%= editObj.getPassword() %>"/></td></tr>
            
            <tr><td>Email:</td><td><input type="email" name="empEmail" value="<%= editObj.getEmpEmail() %>"/></td></tr>
            
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

		<form action="viewByIdEmp" method="get">
			<input type="number" name="viewEmpId"> 
			<input type="submit" value="View Employee By Id">
		</form>
		<% EmpLoginBean empObjById = (EmpLoginBean)session.getAttribute("viewEmpId");
		   if(empObjById != null){ 
		 %>
		 <p>Raw Employee Object Data: ${empObjById}</p>
	<div style="margin: 50px auto; width: 400px; text-align: center;">
		<table border="1">
		   <tr><td>Employee ID:</td><td>${empObjById.empID}</td></tr>
		   <tr><td>Name:</td><td>${empObjById.empName}</td></tr>
		   <tr><td>Email:</td><td>${empObjById.empEmail}</td></tr>
		   <tr><td>Country:</td><td>${empObjById.country}<td></tr> 
		</table>
	</div>
	<% } %>
		 
 <br/> 
 <br/>

		<form action="viewByNameEmp" method="get">
			<input type="text" name="viewEmpName"> 
			<input type="submit" value="View Employee By Name">
		</form>
		<% 
		List<EmpLoginBean> searchList = (List<EmpLoginBean>) session.getAttribute("viewEmpName");
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
		for(EmpLoginBean emp : searchList){
		%>
		<tr>
		<td><%=emp.getEmpID() %></td>
		<td><%=emp.getEmpName() %></td>
		<td><%=emp.getEmpEmail() %></td>
		<td><%=emp.getCountry()%></td>
	    </tr>
	    <% 
		}
		   }
	    %>
		</table>

<br/>  
<br/>  
      <a href="/EmployeeSystem/displayImageEmp">View Photo</a>
<br/>
<br/>   
<jsp:include page="footer.jsp" />

