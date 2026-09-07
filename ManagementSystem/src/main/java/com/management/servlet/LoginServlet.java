package com.management.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.management.dto.AdminDTO;
import com.management.dto.EmployeeDTO;
import com.management.dto.GuestDTO;
import com.management.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "LoginServlet", urlPatterns = {"/employeeLogin","/adminLogin","/guestLogin"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("Method Name: doPost");
        String subPath = request.getPathInfo();  // Returns "null"
        String servletPath = request.getServletPath();// Returns "/employeeLogin"
        
		 System.out.println("servletPath "+servletPath);
		 System.out.println("subPath "+subPath);
		 
		 if("/employeeLogin".equals(servletPath)) {
			 System.out.println("-----------Employee Login -------------");
			 employeeLogin(request,response);
			 
		 }else if("/adminLogin".equals(servletPath)) {
			 System.out.println("-----------Admin Login -------------");
			 adminLogin(request, response);
			 
		 }else if("/guestLogin".equals(servletPath)) {
				System.out.println("-----------Guest Login -------------");
			 guestLogin(request, response);
			 
		 }else {
		        String errorMessage ="Unauthorised Login request!";
		        // Authentication failed: Redirect back to login with error trigger
				request.setAttribute("errorMessage", errorMessage);
				request.setAttribute("errorCode", "101-Return From LoginServlet");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
		 }
	}

	private void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("Method Name: Employee Login");
		String empName = request.getParameter("empName");
		String password = request.getParameter("password");

		EmployeeDTO empObj=LoginService.validateEmployee(empName, password);
		
		HttpSession session=null;
		
		if(empObj != null) {
			session =request.getSession(true); // LoginListener will be called here
		    // Authentication successful: Save user info in the session scope
		    session.setAttribute("empName", empObj.getEmpName());
		    session.setAttribute("empObj", empObj);
		    response.sendRedirect("home.jsp");
		} else {
			String errorMessage ="Employee name or password error!";
		    // Authentication failed: Redirect back to login with error trigger
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("errorCode", "202-Return From LoginServlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("Method Name: Admin Login");
		String adminName = request.getParameter("adminName");
		String adminPass = request.getParameter("adminPass");

		AdminDTO adminObj=LoginService.validateAdmin(adminName, adminPass);
		
		HttpSession session=null;
		
		if(adminObj != null) {
			session =request.getSession(true); // LoginListener will be called here
		    // Authentication successful: Save user info in the session scope
		    session.setAttribute("adminName", adminObj.getAdminName());
		    session.setAttribute("adminObj", adminObj);
		    response.sendRedirect("home.jsp");
		} else {
			String errorMessage ="Admin name or password error!";
		    // Authentication failed: Redirect back to login with error trigger
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("errorCode", "303-Return From LoginServlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void guestLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("Method Name: Guest Login");
	String guestName = request.getParameter("guestName");
	String guestPass = request.getParameter("guestPass");
	
	GuestDTO guestObj = LoginService.validateGuest(guestName, guestPass);
	
	HttpSession session = null;

	if(guestObj != null) {
		session = request.getSession();
		session.setAttribute("guestName", guestObj.getGuestName());
		session.setAttribute("guestObj", guestObj);
		response.sendRedirect("home.jsp");
	}else {
		String errorMessage ="Guest name or password error!";
	    // Authentication failed: Redirect back to login with error trigger
		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("errorCode", "404-Return From LoginServlet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	}

}
