package com.admincrud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(description = "EmployeeServlet", urlPatterns = { "/admin/*" ,"/saveAdmin","/updateAdmin",
		"/editAdmin" ,"/deleteAdmin" })

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final Logger logger = Logger.getLogger(AdminServlet.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("Get method invoked");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String pathInfo = request.getPathInfo();
		
		if("/viewById".equals(pathInfo)) {
			viewAdminById(request, out);
			
		}else if("viewByName".equals(pathInfo)) {
			viewAdminByName(request, out);
			
		}else {
			listAllAdmin(out);
		}
		out.close();
	}
	
private void listAllAdmin(PrintWriter out) {
		// TODO Auto-generated method stub
	 out.println("<a href='index.html'>Add New Admin</a>");  
     out.println("<h1>Admin List</h1>");  
     
     List<AdminDTO> list = AdminService.getAdminList();
     
     out.print("<table border='1' width='100%'");  
     out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th> "+ 
             " <th>Edit</th><th>Delete</th></tr>"); 
     for(AdminDTO e: list) {
   	  out.print("<tr><td>"+e.getAdminId()+"</td><td>"+e.getAdminName()+"</td>"+  
	              "<td>"+e.getMailId()+"</td><td>"+e.getCountry()+"</td>"+
	              // Form uses POST because HTML doesn't natively support PUT
	              "<td><form action='editAdmin' method='post'> \r\n"
	              // Hidden input to flag this as a PUT operation
	              +"<input type='hidden' name='_method' value='PUT'>"
	              + "     <input type='hidden' name='editAdminId' value='"+e.getAdminId()+"'/> \r\n"
	              + "    <button type='submit'>Edit</button> \r\n"
	              + "</form></td>"+
	              // Form uses POST because HTML doesn't natively support DELETE
					"<td><form action='deleteAdmin' method='post'> \r\n"
					  // Hidden input to flag this as a PUT operation
		              +"<input type='hidden' name='_method' value='DELETE'>"
					+ "     <input type='hidden' name='deleteAdminId' value='"+e.getAdminId()+"' /> \r\n"
					+ "    <button type='submit'>Delete</button> \r\n"
					+ "</form></td></tr>");  
     }
     out.print("</table>");
	}

private void viewAdminById(HttpServletRequest request, PrintWriter out) {
		
		out.print("<h2>Admin BY ID</h2>");
		String viewAdminId = request.getParameter("viewAdminId");
		int adminId = 0;
		if(viewAdminId != null) {
			adminId = Integer.parseInt(viewAdminId);
		}
		AdminDTO adto = AdminService.getAdminById(adminId); 
		
		if(adto == null) {
			out.print("No record found for admin id: "+adminId);
		}{
			out.print("<table border='1'>");
			out.print("<tr><td>Admin ID: </td><td>"+adto.getAdminId()+"</td></tr>");  
			out.print("<tr><td>Name:</td><td>"+adto.getAdminName()+"</td></tr>");  
			out.print("<tr><td>Email:</td><td>"+adto.getMailId()+"</td></tr>");  
			out.print("<tr><td>Country:</td><td>"+adto.getCountry()+"<td></tr>");   
			out.print("</table>");  
		}
		
	}
private void viewAdminByName(HttpServletRequest request, PrintWriter out) {
	// TODO Auto-generated method stub
	out.println("<h1>Admin BY Name</h1>"); 
	String viewAdminName = request.getParameter("viewAdminName");
	List<AdminDTO> adminList = null;
	if(viewAdminName != null) {
		adminList=AdminService.getAdminByName(viewAdminName);
	}
	
	if(adminList == null) {
		  out.print("No record found for admin name: "+viewAdminName); 
	}{ 
   		  out.print("<table border='1' width='80%'");  
	      out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Country</th></tr>");  
	        for(AdminDTO e:adminList){  
	       out.print("<tr>"
	       		+ "<td>"+e.getAdminId()+"</td><td>"+e.getAdminName()+"</td>"+  
	              "<td>"+e.getMailId()+"</td><td>"+e.getCountry()+"</td>"
	              + "</tr>");  
	      }  
	      out.print("</table>");  
   	   }
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodOverride = request.getParameter("_method");
		String editAdminId = request.getParameter("editAdminId");
		
		int updateAdminId = 0;
		if(editAdminId != null) {
			updateAdminId = Integer.parseInt(editAdminId);
		}
		if("PUT".equalsIgnoreCase(methodOverride)) {
			logger.info("PUT method");
			doPut(request, response);
		}else if("DELETE".equalsIgnoreCase(methodOverride)) {
			logger.info("DELETE method");
			doDelete(request, response);
		}else if(updateAdminId > 0) {
			logger.info("POST method for update");
			updateAdminRecord(request, response);
		}else {
			logger.info("POST method for create");
			  saveAdminRecord(request, response);
		}
	}

	private void saveAdminRecord(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// TODO Auto-generated method stub
        response.setContentType("text/html");
		
//		String adminName = (String) request.getAttribute("adminNameFromFilter");
        String adminName = request.getParameter("adminName");
		String mailId = request.getParameter("mailId");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		
		AdminDTO adm = new AdminDTO();
		adm.setAdminName(adminName);
		adm.setMailId(mailId);
		adm.setPassword(password);
		adm.setCountry(country);
		
		int status = AdminService.addAdmin(adm);
		System.out.println("Status: "+status);
		logger.info("Status: "+status);
	PrintWriter out = response.getWriter();
	if(status > 0) {
		out.print("<p colour='#76D7C4'>Record inserted successfully.<p>");
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.include(request, response);
	}else {
		out.print("<p colour='#F1948A'>Sorry! unable to save record.<p>");
	}
	out.close();
	}

	private void updateAdminRecord(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		
		String editAdminId = request.getParameter("editAdminId");
		int adminId = Integer.parseInt(editAdminId);
	
//		String adminName = (String) request.getAttribute("adminNameFromFilter");
		String adminName = request.getParameter("adminName");
		String password=request.getParameter("password");  
		String mailId=request.getParameter("mailId");  
		String country=request.getParameter("country");
		
		AdminDTO adm=new AdminDTO();  
		adm.setAdminId(adminId);  
		adm.setAdminName(adminName);  
		adm.setPassword(password);  
		adm.setMailId(mailId);  
		adm.setCountry(country);
		
		int status = AdminService.updateAdmin(adm);
		if(status>0) {
			response.sendRedirect("admin");
		}else {
			out.println("Sorry! unable to update record");
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("PUT Method ");
		response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Admin</h1>"); 
	        
	    String adminId = request.getParameter("editAdminId");
	    int id = Integer.parseInt(adminId);
	    
	    AdminDTO emp=AdminService.getAdminById(id);
	    
	    out.print("<form action='updateAdmin' methos='post'>");
	    out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='editAdminId' value='"+emp.getAdminId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='adminName' value='"+emp.getAdminName()+"'/></td></tr>");  
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

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("DELETE Method ");
		String deleteAdminId=request.getParameter("deleteAdminId");  
        int adminId=Integer.parseInt(deleteAdminId);  
        AdminService.deleteAdmin(adminId);
        response.sendRedirect("admin");
	}

}
