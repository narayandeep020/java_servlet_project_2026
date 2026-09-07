<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.management.dto.GuestDTO"%>
<%@ page import="com.management.dao.GuestDao"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.Base64" %>


 <jsp:include page="header.jsp" />
    
    <h1>Welcome to Guest page</h1>

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
       
  <a href="createGuest">Add New Guest</a>
     <% 
            String createGuest = (String)session.getAttribute("createGuest");
            if (createGuest != null) { 
        %>
<form action="saveGuest" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td><input type='hidden' name='guestId' value='-1' />
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="guestName" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="guestPass" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="guestEmail" /></td>
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
			<td>Upload Image:</td>
			<td><input type="file" name="image" accept="image/*"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save Guest" /></td>
		</tr>
	</table>
</form>
  <% 
        }   
       %>
<br/>
<br/>
       
 <a href="guest">View All Guest</a>
<%
List<GuestDTO> list = (List<GuestDTO>) session.getAttribute("guestList");
      if (list != null) { 
%>

 <p>Raw Guest List Data: ${guestList}</p>
  
<table border='1' >
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Country</th>
		<th>Image</th>
		<th>Download Image</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<%
	for (GuestDTO e : list) {
	%>
	<tr>
		<td><%=e.getGuestId() %></td>
		<td><%=e.getGuestName() %></td>
		<td><%=e.getGuestEmail() %></td>
		<td><%= e.getCountry()%></td>
		<%     
			 byte[] imageBytes = (byte[]) e.getImage();       
			 if (imageBytes != null && imageBytes.length > 0){
				 
			     String base64Image = Base64.getEncoder().encodeToString(imageBytes); 
		 %>  
		<td><img src="data:image/jpeg;base64,<%= base64Image %>" alt="User Image"   width="100" height="100"/></td>
		
	<%  } else { %>         
           <td><p>No image available.</p></td>
    <%   } %>
  
       <td>
           <form action="downloadImg" method="get">
               <input type="hidden" name="guestId" value="<%= e.getGuestId() %>"/>
               <button type="submit">Download Image</button>
           </form>
        </td>
 
		<!-- Form uses POST because HTML doesn't natively support PUT -->
		<td><form action='editGuest' method='post'>
				<!-- Hidden input to flag this as a PUT operation -->
				<input type='hidden' name='_method' value='PUT'>
				<input type='hidden' name='editGuestId' value='<%= e.getGuestId()%>' />
				<button type='submit'>Edit</button>
			</form></td>
		<!-- Form uses POST because HTML doesn't natively support DELETE-->
		<td><form action='deleteGuest' method='post'>
				<!-- Hidden input to flag this as a PUT operation -->
				<input type='hidden' name='_method' value='DELETE'>
				 <input type='hidden' name='deleteGuestId' value='<%= e.getGuestId()%>' />
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
   GuestDTO  editGuestObj=(GuestDTO)session.getAttribute("editGuestObj"); 
            if (editGuestObj != null) { 
        %>
<form action='updateGuest' method='post'>
<table>
<tr><td></td><td><input type='hidden' name='editGuestId' value='<%=editGuestObj.getGuestId() %>'/></td></tr>
<tr><td>Name:</td><td><input type='text' name='guestName' value='<%=editGuestObj.getGuestName() %>'/></td></tr>
<tr><td>Password:</td><td><input type='password' name='guestPass' value='<%=editGuestObj.getGuestPass() %>'/></td></tr>
<tr><td>Email:</td><td><input type='email' name='guestEmail' value='<%=editGuestObj.getGuestEmail()%>'/></td></tr>
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
       
<form action="viewByIdGuest" method="get">
	<input type="number" name="viewGuestId"> <input type="submit"
		value="View Guest By Id">
</form>

<%-- Retrieve the object from the request scope and cast it --%>
   <% 
   GuestDTO  guestObjByID=(GuestDTO)session.getAttribute("guestObjByID"); 
            if (guestObjByID != null) { 
        %>
          <p>Raw Guest Object Data: ${guestObjByID}</p>
   
    <div style="margin: 50px auto; width: 400px; text-align: center;">
			<table border='1'>
				<tr><td>Guest ID: </td><td>${guestObjByID.guestId}</td></tr> 
				<tr><td>Name:</td><td>${guestObjByID.guestName}</td></tr>
				<tr><td>Email:</td><td>${guestObjByID.guestEmail}</td></tr>
				<tr><td>Country:</td><td>${guestObjByID.country}<td></tr>   
			</table>  
    </div>
        <% 
        }   
       %>
<br/>
<br/>


<form action="viewByNameGuest" method="get">
	<input type="text" name="viewGuestName"> <input type="submit"
		value="View Guest By Name">
</form>
<%
List<GuestDTO> guestSearchList = (List<GuestDTO>) session.getAttribute("guestSearchList");
      if (guestSearchList != null) { 
%>

 <p>Raw Employee List Data: ${guestSearchList}</p>
 
 
<table border='1' >
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Country</th>
	</tr>
	<%
	for (GuestDTO guest : guestSearchList) {
	%>
	<tr>
		<td><%=guest.getGuestId() %></td>
		<td><%=guest.getGuestName() %></td>
		<td><%=guest.getGuestEmail() %></td>
		<td><%=guest.getCountry()%></td>
	</tr>
	<%
	 } // ends for loop
   }// ends if condition 
	%>
</table>


<br />
<br />
<a href="/ManagementSystem/displayImageG">View Image</a>


<!-- Step 3: Inject the common footer -->
<jsp:include page="footer.jsp" />