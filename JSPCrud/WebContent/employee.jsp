<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="com.emp.crud.EmployeeDTO" %>
<%@ page import="com.emp.crud.EmployeeService" %>
<%@ page import="java.util.List" %> 
<%@ page import="java.io.PrintWriter" %> 
<%@ page import="java.io.IOException" %> 
<%@ page import="javax.servlet.RequestDispatcher" %>
    
<%! 
private final Logger logger = Logger.getLogger(this.getClass().getName());
%>

<%
String httpMethod = request.getMethod();

String tunneledMethod = request.getParameter("_method");
if (tunneledMethod != null && (tunneledMethod.equalsIgnoreCase("PUT") || tunneledMethod.equalsIgnoreCase("DELETE"))) {
    httpMethod = tunneledMethod.toUpperCase();
}

 String message = "";

 if (httpMethod.equals("POST")) {
     // CREATE Operation
 	    String editEmpId = request.getParameter("editEmpId");
		int updateEmpId = 0; 
		if(editEmpId != null) {
			updateEmpId= Integer.parseInt(editEmpId); 
		}
		
		if(updateEmpId >0){
	    	// Update record by post method
	    	logger.info("POST Method for update");
	        updateEmployeeRecord(request, response);  
	        message = "Successfully executed [POST]: Update ";
	    }else{
	    	// Create record by post method
	    	logger.info("POST Method for Create");
	        saveEmployeeRecord(request, response);
	        message = "Successfully executed [POST]: Created   ";

	    }
		
 }
 else if (httpMethod.equals("PUT")) {
     // UPDATE Operation
 	 logger.info("PUT Method ");   
 	 editEmployee(request, response);
 }
 else if(httpMethod.equals("DELETE")) { 
     // DELETE Operation
		logger.info("DELETE Method ");
		String deleteEmpId=request.getParameter("deleteEmpId");  
        int empId=Integer.parseInt(deleteEmpId);  
        EmployeeService.deleteEmployee(empId);
   
 }else{
 	 // GET falls through naturally to render the UI below
 	 
	 String pathInfo = request.getPathInfo(); 
     
     if ("/viewById".equals(pathInfo)) {
         // Handle profile GET
     	 viewEmployeeById(request, response);
  	   
     } else if ("/viewByName".equals(pathInfo)) {
         // Handle settings GET
     	viewEmployeeByName(request, response);
     }else {
	
         listAllEmployee(request, response);  
     } 
 	 
 }
 
 %>
	
<%!
private void viewEmployeeByName(HttpServletRequest request, HttpServletResponse response )
		throws IOException, ServletException{
	response.setContentType("text/html");  
    PrintWriter out=response.getWriter();  
    
	 out.println("<h1>Employees BY Name</h1>");  
	 String viewEmpName = request.getParameter("viewEmpName");
	 List<EmployeeDTO> empList=null;
	if(viewEmpName != null) {
		 empList=EmployeeService.getEmployeeByName(viewEmpName);
	}

	   if (empList==null) {
	  out.print("No record found for employee name: "+viewEmpName); 
	   }{ 
		  out.print("<table border='1' width='80%'");  
     out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th></tr>");  
       for(EmployeeDTO e:empList){  
      out.print("<tr>"
      		+ "<td>"+e.getEmpId()+"</td><td>"+e.getEmpName()+"</td>"+  
             "<td>"+e.getMailId()+"</td><td>"+e.getCountry()+"</td>"
             + "</tr>");  
     }  
     out.print("</table>");  
	   }
}
 
private void viewEmployeeById(HttpServletRequest request, HttpServletResponse response )
		throws IOException, ServletException{
	
	 response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     
	out.println("<h1>Employees BY ID</h1>"); 
	 String viewEmpId = request.getParameter("viewEmpId");
	int empId = 0; 
	if(viewEmpId != null) {
		empId= Integer.parseInt(viewEmpId); 
	}
	 
	   EmployeeDTO emp=EmployeeService.getEmployeeById(empId);
	   
	   if (emp==null) {
	  out.print("No record found for employee Id: "+empId); 
	   }{ 
	out.print("<table border='1'>");  
	out.print("<tr><td>Employee ID: </td><td>"+emp.getEmpId()+"</td></tr>");  
	out.print("<tr><td>Name:</td><td>"+emp.getEmpName()+"</td></tr>");  
	out.print("<tr><td>Email:</td><td>"+emp.getMailId()+"</td></tr>");  
	out.print("<tr><td>Country:</td><td>"+emp.getCountry()+"<td></tr>");   
	out.print("</table>");  
	   }
}
	
private void editEmployee(HttpServletRequest request, HttpServletResponse response )
		throws IOException, ServletException {
	 response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     
     out.println("<h1>Update Employee</h1>");  
 
     String empId=request.getParameter("editEmpId");  
     
     int id=Integer.parseInt(empId);  
       
     EmployeeDTO emp=EmployeeService.getEmployeeById(id);
       
     out.print("<form action='updateEmployee' method='post'>");  
     out.print("<table>");  
     out.print("<tr><td></td><td><input type='hidden' name='editEmpId' value='"+emp.getEmpId()+"'/></td></tr>");  
     out.print("<tr><td>Name:</td><td><input type='text' name='empName' value='"+emp.getEmpName()+"'/></td></tr>");  
     out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+emp.getPassword()+
     		"'/></td></tr>");  
     out.print("<tr><td>Email:</td><td><input type='email' name='mailId' value='"+emp.getMailId()+"'/></td></tr>");  
     out.print("<tr><td>Country:</td><td>");  
     out.print("<select name='country' style='width:150px'>");  
     out.print("<option>India</option>");  
     out.print("<option>USA</option>");  
     out.print("<option>UK</option>");  
     out.print("<option>Other</option>");  
     out.print("</select>");  
     out.print("</td></tr>");  
     out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
     out.print("</table>");  
     out.print("</form>");  
       
     out.close();    
}
	
private void listAllEmployee(HttpServletRequest request, HttpServletResponse response ) 
		throws IOException, ServletException{
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	  out.println("<a href='index.html'>Add New Employee</a>");  
	  out.println("<br/>");
      out.println("<h1>Employees List</h1>");  
      
    List<EmployeeDTO> list=EmployeeService.getEmployeeList();
      
    out.print("<table border='1' width='100%'");  
    out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th> "+ 
            " <th>Edit</th><th>Delete</th></tr>");  
      for(EmployeeDTO e:list){  
     out.print("<tr>"
     		+ "<td>"+e.getEmpId()+"</td><td>"+e.getEmpName()+"</td>"+  
            "<td>"+e.getMailId()+"</td><td>"+e.getCountry()+"</td>"+
            // Form uses POST because HTML doesn't natively support PUT
            "<td><form action='editEmployee' method='post'> "
            // Hidden input to flag this as a PUT operation
            +"<input type='hidden' name='_method' value='PUT'>"
            + "     <input type='hidden' name='editEmpId' value='"+e.getEmpId()+"'/> "
            + "    <button type='submit'>Edit</button> \r\n"
            + "</form></td>"+
            // Form uses POST because HTML doesn't natively support DELETE
				"<td><form action='deleteEmployee' method='post'> "
				  // Hidden input to flag this as a PUT operation
	              +"<input type='hidden' name='_method' value='DELETE'>"
				+ "     <input type='hidden' name='deleteEmpId' value='"+e.getEmpId()+"'/> "
				+ "    <button type='submit'>Delete</button> \r\n"
				+ "</form></td>"
				+ "</tr>");  
    }  
    out.print("</table>");  
      
   
}
 
private void saveEmployeeRecord(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   // using through filter
		String empName=(String) request.getParameter("empName");
		
		// Using directly from form
		String mailId=request.getParameter("mailId");
		String password=request.getParameter("password");
		String country=request.getParameter("country");
		
		EmployeeDTO  emp = new EmployeeDTO();
		 emp.setEmpName(empName);
		 emp.setMailId(mailId);
		 emp.setPassword(password);
		 emp.setCountry(country);
		 
		 int status =EmployeeService.addEmployee(emp);
		 System.out.println("status: " +status);
		 logger.info("status  "+status);
	
		if(status >0) {
			out.print("<p colour='#76D7C4'>Record inserted successfully.<p>");
			RequestDispatcher rd= request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
			out.print("<p colour='#F1948A'>Sorry! unable to save record.<p>");
		}
		
		out.close();
}


   
private void updateEmployeeRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
	response.setContentType("text/html");  
	PrintWriter out=response.getWriter();  
	  
	String editEmpId=request.getParameter("editEmpId");  
	int empId=Integer.parseInt(editEmpId);  
	
	// using through filter
// 	String empName=(String) request.getAttribute("empNameFromFilter"); 
	
	// empName direct from Form  
	String empName=request.getParameter("empName");  
	logger.info("Employee Name from form"+ empName); 
	
	String password=request.getParameter("password");  
	String mailId=request.getParameter("mailId");  
	String country=request.getParameter("country");  
	  
	EmployeeDTO emp=new EmployeeDTO();  
	emp.setEmpId(empId);  
	emp.setEmpName(empName);  
	emp.setPassword(password);  
	emp.setMailId(mailId);  
	emp.setCountry(country);  
	 
	int status=EmployeeService.updateEmployee(emp) ; 
	
	if(status>0){  
	    response.sendRedirect("employee");  
	}else{  
	    out.println("Sorry! unable to update record");  
	}  
	  
	out.close();
}
 %>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Crud</title>
</head>
<body>
<h2>JSP Crud Example</h2>
</body>
</html>