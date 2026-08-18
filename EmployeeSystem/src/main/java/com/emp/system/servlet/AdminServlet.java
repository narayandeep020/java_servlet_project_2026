package com.emp.system.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.system.bean.AdminLoginBean;
import com.emp.system.service.AdminLoginService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(description = "AdminServlet", urlPatterns = { "/admin","/viewById","/viewByName","/createAdmin","/saveAdmin","/updateAdmin","/editAdmin" ,"/deleteAdmin","/displayImage" })

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
		logger.info("Method Name: doGet");
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo: "+pathInfo);
		String servletInfo = request.getServletPath();
		System.out.println("servletInfo: "+servletInfo);
		
		if("/viewById".equals(servletInfo)) {
			viewAdminById(request, response);
			
		}else if("/viewByName".equals(servletInfo)) {
			viewAdminByName(request, response);
			
		}else if("/createAdmin".equals(servletInfo)){
			createAdmin(request, response);
			
		}else if("/displayImage".equals(servletInfo)){
			displayImage(request, response);
			
		}else {
			getAdminList(request, response);
		   
		}

	}
	
private void getAdminList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		removeAttribute(request);
		HttpSession session = request.getSession();
		List<AdminLoginBean> list = AdminLoginService.getAdminList();
		session.setAttribute("adminList", list);
		response.sendRedirect("adminDash.jsp");
		
}
	
private void displayImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
	response.setContentType("image/jpg");
	ServletOutputStream out = response.getOutputStream();
	
	String resourcePath = "images/As man thinking.jpg";
	InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
	
    BufferedInputStream bin = new BufferedInputStream(input);  
    
    BufferedOutputStream bout = new BufferedOutputStream(out); 
    
   int ch = 0;
   while((ch = bin.read()) != -1) {
	   bout.write(ch);
   }
   input.close();
   bin.close();
   bout.close();
   out.close();
}


private void createAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
	removeAttribute(request);
	HttpSession session = request.getSession();
	session.setAttribute("createAdmin", "CREATE_ADMIN");
	response.sendRedirect("adminDash.jsp");
	}

private void viewAdminById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	removeAttribute(request);
	HttpSession session = request.getSession();
	String viewAdminId = request.getParameter("viewAdminId");
    int adminId = 0;
    if (viewAdminId != null ) {
        adminId = Integer.parseInt(viewAdminId);
    }
    AdminLoginBean adminById = AdminLoginService.getAdminById(adminId);

   session.setAttribute("adminById", adminById);
   response.sendRedirect("adminDash.jsp");
		
	}
private void viewAdminByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	removeAttribute(request);
	HttpSession session = request.getSession();
	String viewAdminName = request.getParameter("viewAdminName");
	List<AdminLoginBean> adminList = null;
	if(viewAdminName != null) {
		adminList=AdminLoginService.getAdminByName(viewAdminName);
	}

	session.setAttribute("adminList", adminList);
	response.sendRedirect("adminDash.jsp");
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
		
//		String adminName = (String) request.getAttribute("adminNameFromFilter");
        String adminName = request.getParameter("adminName");
		String adminEmail = request.getParameter("adminEmail");
		String adminPass = request.getParameter("adminPass");
		String country = request.getParameter("country");
		
		AdminLoginBean adm = new AdminLoginBean();
		adm.setAdminName(adminName);
		adm.setAdminEmail(adminEmail);
		adm.setAdminPass(adminPass);
		adm.setCountry(country);
		
		int status = AdminLoginService.addAdmin(adm);
		System.out.println("Status: "+status);
		logger.info("Status: "+status);
		removeAttribute(request);
		HttpSession session = request.getSession();
		String insertMessage = null;
		
	if(status > 0) {
		insertMessage = "<p colour='#76D7C4'>Record inserted successfully.<p>";
	}else {
		insertMessage = "<p colour='#F1948A'>Sorry! unable to save record.<p>";
	}
	
	session.setAttribute("insertMessage", insertMessage);
	response.sendRedirect("adminDash.jsp");
	}

	private void updateAdminRecord(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// TODO Auto-generated method stub  
		String editAdminId = request.getParameter("editAdminId");
		int adminId = Integer.parseInt(editAdminId);
	
//		String adminName = (String) request.getAttribute("adminNameFromFilter");
		String adminName = request.getParameter("adminName");
		String adminPass=request.getParameter("adminPass");  
		String adminEmail=request.getParameter("adminEmail");  
		String country=request.getParameter("country");
		
		AdminLoginBean adm=new AdminLoginBean();  
		adm.setAdminId(adminId);  
		adm.setAdminName(adminName);  
		adm.setAdminPass(adminPass);  
		adm.setAdminEmail(adminEmail);  
		adm.setCountry(country);
		
		int status = AdminLoginService.updateAdmin(adm);
		removeAttribute(request);
		HttpSession session = request.getSession();
		String updateMessage = null;
		if(status>0) {
			updateMessage = "<p colour='#76D7C4'>Record updated success.<p>";
		}else {
			updateMessage = "Sorry! unable to update record";
		}
		
		session.setAttribute("updateMessage", updateMessage);
		response.sendRedirect("adminDash.jsp");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("PUT Method ");
		removeAttribute(request);
		HttpSession session = request.getSession();
		
        String adminId = request.getParameter("editAdminId");
        int id = Integer.parseInt(adminId);

        AdminLoginBean editAdmin = AdminLoginService.getAdminById(id);

        session.setAttribute("editAdmin", editAdmin);
        response.sendRedirect("adminDash.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("DELETE Method ");
		String deleteAdminId=request.getParameter("deleteAdminId");  
        int adminId=Integer.parseInt(deleteAdminId);  
        AdminLoginService.deleteAdmin(adminId);
        
        removeAttribute(request);
        
        HttpSession session = request.getSession();
        String deleteMessage = "<p colour='#76D7C4'>Record deleted successfully.<p>";
        session.setAttribute("deleteMessage", deleteMessage);
        response.sendRedirect("adminDash.jsp");
	}
	
	private void removeAttribute(HttpServletRequest request) {
		
		 HttpSession session = request.getSession(false);
		 if(session != null) {
			 java.util.Enumeration<String> attributeNames = session.getAttributeNames();
			 while(attributeNames.hasMoreElements()) {
				 String attrNames = attributeNames.nextElement();
				 session.removeAttribute(attrNames);
			 }
		 }		
	}
}
