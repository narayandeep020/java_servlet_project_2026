package com.management.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.management.dto.AdminDTO;
import com.management.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(description = "Admin Servlet", urlPatterns = { "/admin", "/viewByIdAdmin", "/viewByNameAdmin", "/createAdmin", "/displayImageA", "/saveAdmin", 
		"/updateAdmin", "/editAdmin", "/deleteAdmin"})

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(AdminServlet.class);
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
		
		String subPath = request.getPathInfo();
		String servletPath = request.getServletPath();
		
		System.out.println("subPath "+subPath);
		System.out.println("servletPath "+servletPath);
		
		if("/viewByIdAdmin".equals(servletPath)) {
			viewAdminById(request, response);
			
		}else if("/viewByNameAdmin".equals(servletPath)) {
			viewAdminByName(request, response);
			
		}else if("/createAdmin".equals(servletPath)) {
			createAdmin(request, response);
			
		}else if("/displayImageA".equals(servletPath)){
			displayImage(request, response);
			
		}else {
			getAdminList(request, response);
		}
	}

	private void getAdminList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method name: getAdminList");
		
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		List<AdminDTO> list = AdminService.getAdminList();
		session.setAttribute("adminList", list);
		response.sendRedirect("admin.jsp");
	}

	private void displayImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: displayImage");
		
		response.setContentType("image/jpg");  
	    ServletOutputStream out;  
	    out = response.getOutputStream();  
	  
	    // 1. Define the relative path starting from the root of the classpath  
	    // file is inside src/main/resources under images folder 
	    
        String resourcePath = "images/sun_flower.jpg";
	    InputStream fin =  Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
	      
	    BufferedInputStream bin = new BufferedInputStream(fin);  
	    
	    BufferedOutputStream bout = new BufferedOutputStream(out);  
	    int ch =0; ;  
	    while((ch=bin.read())!=-1)  
	    {  
	    bout.write(ch);  
	    }  
	      
	    bin.close();  
	    fin.close();  
	    bout.close();  
	    out.close();  
	}

	private void createAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: createAdmin");
		
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		session.setAttribute("createAdmin", "CREATE_ADMIN");
		response.sendRedirect("admin.jsp");
		
	}

	private void viewAdminByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: viewAdminByName");
		
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String viewAdminName = request.getParameter("viewAdminName");
		List<AdminDTO> adminSearchList = null;
		if (viewAdminName != null) {
			adminSearchList = AdminService.getAdminByName(viewAdminName);
		}
		session.setAttribute("adminSearchList", adminSearchList);
		response.sendRedirect("admin.jsp");
	}

	private void viewAdminById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: viewAdminById");
		
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String viewAdminId = request.getParameter("viewAdminId");
		int adminId = 0;
		if (viewAdminId != null) {
			adminId = Integer.parseInt(viewAdminId);
		}

		AdminDTO adminObjByID = AdminService.getAdminById(adminId);

		session.setAttribute("adminObjByID", adminObjByID);
		response.sendRedirect("admin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Method Name: doPost");

		String methodOverride = request.getParameter("_method");
		String editAdminId = request.getParameter("editAdminId");
		
		int updateAdminId = 0;
		if (editAdminId != null) {
			updateAdminId = Integer.parseInt(editAdminId);
		}
		
		if ("PUT".equalsIgnoreCase(methodOverride)) {
			// Manually forward the request and response to doPut
			logger.info("PUT Method");
			doPut(request, response);
			
		} else if ("DELETE".equalsIgnoreCase(methodOverride)) {
			// Manually forward the request and response to doDelete
			logger.info("DELETE Method");
			doDelete(request, response);
			
		} else if (updateAdminId > 0) {
			// Update record by post method
			logger.info("POST Method for update");
			updateAdminRecord(request, response);
			
		} else {
			// Create record by post method
			logger.info("POST Method for Create");
			saveAdminRecord(request, response);

		}
	}

	private void saveAdminRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: saveAdminRecord");

//		String empName = (String) request.getAttribute("empNameFromFilter");
		
		String adminName = request.getParameter("adminName");
		String adminEmail = request.getParameter("adminEmail");
		String adminPass = request.getParameter("adminPass");
		String country = request.getParameter("country");

		AdminDTO adm = new AdminDTO();
		adm.setAdminName(adminName);
		adm.setAdminEmail(adminEmail);
		adm.setAdminPass(adminPass);
		adm.setCountry(country);

		int status = AdminService.addAdmin(adm);
		System.out.println("status: " + status);
		logger.info("status  " + status);
		
		removeAttributes( request);
		
		HttpSession session = request.getSession(); // use existing session
		String insertMessage = null;

		if (status > 0) {
			insertMessage = "<p colour='#76D7C4'>Record inserted successfully.<p>";
		} else {
			insertMessage = "<p colour='#F1948A'>Sorry! unable to save record.<p>";
		}

		session.setAttribute("insertMessage", insertMessage);
		response.sendRedirect("admin.jsp");
		
	}

	private void updateAdminRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: updateAdminRecord");
	
		String editAdminId = request.getParameter("editAdminId");
		int adminId = Integer.parseInt(editAdminId);

		// using through filter
//		String adminName = (String) request.getAttribute("adminNameFromFilter");

		// adminName direct from Form
		String adminName = request.getParameter("adminName");
		logger.info("Admin Name from form" + adminName);

		String adminEmail = request.getParameter("adminEmail");
		String adminPass = request.getParameter("adminPass");
		String country = request.getParameter("country");

		AdminDTO adm = new AdminDTO();
		adm.setAdminId(adminId);
		adm.setAdminName(adminName);
		adm.setAdminPass(adminPass);
		adm.setAdminEmail(adminEmail);
		adm.setCountry(country);

		int status = AdminService.updateAdmin(adm);

		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String updateMessage = null;

		if (status > 0) {
			updateMessage = "<p colour='#76D7C4'>Record updated successfully.<p>";
		} else {
			updateMessage = "<p colour='#F1948A'>Sorry! unable to update record.<p>";
		}

		session.setAttribute("updateMessage", updateMessage);
		response.sendRedirect("admin.jsp");
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("Method Name: doPut");
		removeAttributes( request);
		
		HttpSession session = request.getSession(); // use existing session
		String adminId = request.getParameter("editAdminId");

		int id = Integer.parseInt(adminId);

		AdminDTO editAdminObj = AdminService.getAdminById(id);

		session.setAttribute("editAdminObj", editAdminObj);
		response.sendRedirect("admin.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("Method Name: doDelete");
		String deleteAdminId = request.getParameter("deleteAdminId");
		int adminId = Integer.parseInt(deleteAdminId);
		AdminService.deleteAdmin(adminId);
		
		removeAttributes( request);
		
		HttpSession session = request.getSession(); // use existing session
		String deleteMessage = "<p colour='#76D7C4'>Record deleted successfully.<p>";;
		session.setAttribute("deleteMessage", deleteMessage);
		response.sendRedirect("admin.jsp");
	}

	private void removeAttributes(HttpServletRequest request) {
		logger.info("Method Name: removeAttribute");
		
		HttpSession session = request.getSession(false);

		 if (session != null) {
		     java.util.Enumeration<String> attributeNames = session.getAttributeNames();
		     while (attributeNames.hasMoreElements()) {
		         String attrName = attributeNames.nextElement();
		         session.removeAttribute(attrName);
		     }
		 }
	}

}
