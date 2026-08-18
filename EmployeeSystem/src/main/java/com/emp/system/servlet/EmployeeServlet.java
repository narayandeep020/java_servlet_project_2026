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


import com.emp.system.bean.EmpLoginBean;
import com.emp.system.service.EmpLoginService;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet(description = "EmployeeServlet", urlPatterns = { "/employee", "/viewByIdEmp","/viewByNameEmp","/displayImageEmp","/createEmployee","/saveEmployee","/updateEmployee",
		"/editEmployee" ,"/deleteEmployee" })

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final Logger logger = Logger.getLogger(EmployeeServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		System.out.println("pathInfo: "+pathInfo);
		
		String servletInfo = request.getServletPath();
		System.out.println("servletInfo: "+servletInfo);
		
		if("/viewByIdEmp".equals(servletInfo)) {
			viewEmployeeById(request, response);
			
		}else if("/viewByNameEmp".equals(servletInfo)) {
			viewEmployeeByName(request, response);
			
		}else if("/createEmployee".equals(servletInfo)){
			createEmployee(request, response);
			
		}else if("/displayImageEmp".equals(servletInfo)){
			displayImage(request, response);
			
		}else {
			getEmployeeList(request, response);
		   
		}
	}
	
	private void getEmployeeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		removeAttribute(request);
		HttpSession session = request.getSession();
		List<EmpLoginBean> list = EmpLoginService.getEmployeeList();
		session.setAttribute("empList", list);
		response.sendRedirect("empDash.jsp");
		
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

	private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		removeAttribute(request);
		HttpSession session = request.getSession();
		session.setAttribute("createEmployee", "CREATE_EMPLOYEE");
		response.sendRedirect("empDash.jsp");
		
	}
	
private void viewEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	removeAttribute(request);
	HttpSession session = request.getSession();
	String viewEmpName = request.getParameter("viewEmpName");
	List<EmpLoginBean> empList = null;
	if(viewEmpName != null) {
		empList=EmpLoginService.getEmployeeByName(viewEmpName);
	}

	session.setAttribute("empList", empList);
	response.sendRedirect("empDash.jsp");
	}

	private void viewEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		removeAttribute(request);
		HttpSession session = request.getSession();
		String viewEmpId = request.getParameter("viewEmpId");
	    int empId = 0;
	    if (viewEmpId != null ) {
	    	empId = Integer.parseInt(viewEmpId);
	    }
	    EmpLoginBean empById = EmpLoginService.getEmployeeById(empId);

	   session.setAttribute("empById", empById);
	   response.sendRedirect("empDash.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String methodOverride = request.getParameter("_method");
		String editEmpId = request.getParameter("editEmpId");
		
		int updateEmpId = 0;
		if(editEmpId != null) {
			updateEmpId = Integer.parseInt(editEmpId);
		}
		if("PUT".equalsIgnoreCase(methodOverride)) {
			logger.info("PUT method");
			doPut(request, response);
		}else if("DELETE".equalsIgnoreCase(methodOverride)) {
			logger.info("DELETE method");
			doDelete(request, response);
		}else if(updateEmpId > 0) {
			logger.info("POST method for update");
			updateEmployeeRecord(request, response);
		}else {
			logger.info("POST method for create");
			  saveEmployeeRecord(request, response);
		}
	}

	private void saveEmployeeRecord(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		
//		String empName = (String) request.getAttribute("empNameFromFilter");
		
		String empName = request.getParameter("empName");
		String empEmail = request.getParameter("empEmail");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		
		EmpLoginBean emp = new EmpLoginBean();
		emp.setEmpName(empName);
		emp.setEmpEmail(empEmail);
		emp.setPassword(password);
		emp.setCountry(country);
		
		int status = EmpLoginService.addEmployee(emp);
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
	response.sendRedirect("empDash.jsp");
	
	}

	private void updateEmployeeRecord(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException{

		String editEmpId = request.getParameter("editEmpId");
		int empId = Integer.parseInt(editEmpId);
	
//		String empName = (String) request.getAttribute("empNameFromFilter");
		
		String empName = request.getParameter("empName");
		String password=request.getParameter("password");  
		String empEmail=request.getParameter("empEmail");  
		String country=request.getParameter("country");
		
		EmpLoginBean emp=new EmpLoginBean();  
		emp.setEmpID(empId);  
		emp.setEmpName(empName);  
		emp.setPassword(password);  
		emp.setEmpEmail(empEmail);  
		emp.setCountry(country);
		
		int status = EmpLoginService.updateEmployee(emp);
		removeAttribute(request);
		
		HttpSession session = request.getSession();
		String updateMessage = null;
		if(status>0) {
			updateMessage = "<p colour='#76D7C4'>Record updated success.<p>";
		}else {
			updateMessage = "Sorry! unable to update record";
		}
		session.setAttribute("updateMessage", updateMessage);
		response.sendRedirect("empDash.jsp");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		logger.info("PUT Method ");
		removeAttribute(request);
		HttpSession session = request.getSession();
	        
	    String empId = request.getParameter("editEmpId");
	    int id = Integer.parseInt(empId);
	    
	    EmpLoginBean editEmp=EmpLoginService.getEmployeeById(id);
	    
	    session.setAttribute("editEmp", editEmp);
	    response.sendRedirect("empDash.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("DELETE Method ");
		String deleteEmpId=request.getParameter("deleteEmpId");  
        int empId=Integer.parseInt(deleteEmpId);  
        EmpLoginService.deleteEmployee(empId);
        
        removeAttribute(request);
        
        HttpSession session = request.getSession();
        String deleteMessage = "<p colour='#76D7C4'>Record deleted successfully.<p>";
        session.setAttribute("deleteMessage", deleteMessage);
        response.sendRedirect("empDash.jsp");
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
