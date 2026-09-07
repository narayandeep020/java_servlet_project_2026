package com.management.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(description = "Login Filter", urlPatterns = { "/employeeLogin","/adminLogin","/guestLogin"})
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		 System.out.println("-----------Login Filter called -------------");
		 
		    HttpServletRequest request = (HttpServletRequest) req;
		    HttpServletResponse response = (HttpServletResponse) res;
		    
//		    String subPath = request.getPathInfo();
		    String servletPath = request.getServletPath();
		    
		    if("/employeeLogin".equals(servletPath)) {
		    	employeeLoginFilter(request, response, chain);
		    	
		    }else if("/adminLogin".equals(servletPath)) {
		    	adminLoginFilter(request, response, chain);
		    	
		    }else if("/guestLogin".equals(servletPath)) {
		    	guestLoginFilter(request, response, chain);
		    	
		    }else {
	        	 String errorMessage = "Login failed. Please try again.";
	        	 request.setAttribute("errorMessage", errorMessage);
		         request.setAttribute("errorCode", "111-Return From LoginFilter");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				 dispatcher.forward(request, response);
	        }
		
	}

	private void employeeLoginFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
	    String empName=request.getParameter("empName");
	    String password=request.getParameter("password");
	    
	    int empLength = empName.length();
	    int empPs = password.length();
	    
	    if ((4<=empLength && empLength <=16) && (4<=empPs && empPs<=16)){
	    	System.out.println("-----------Employee Login  Filter 1111-------------");
	        // Allow the request to go to the next filter or target servlet
	        chain.doFilter(request, response);
	    } else {
	    	System.out.println("----------Employee Login Filter 2222-------------");
	         String errorMessage = "Login failed. Please try again.";
	         request.setAttribute("errorMessage", errorMessage);
	         request.setAttribute("errorCode", "13-Return From LoginFilter");
			 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			 dispatcher.forward(request, response);
	    }
		
		
	}

	private void adminLoginFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 String adminName=request.getParameter("adminName");
		 String adminPass=request.getParameter("adminPass");
		 
		    int adminLength = adminName.length();
		    int adminPs = adminPass.length();
		 
     if ((4<=adminLength && adminLength <=16) && (4<=adminPs && adminPs <=16)){
		    	System.out.println("-----------Admin Login Filter 3333-------------");
		        // Allow the request to go to the next filter or target servlet
		        chain.doFilter(request, response);
		    } else {
		    	System.out.println("-----------Admin Login Filter 4444-------------");
		         String errorMessage = "Login failed. Please try again.";
		         request.setAttribute("errorMessage", errorMessage);
		         request.setAttribute("errorCode", "12-Return From LoginFilter");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				 dispatcher.forward(request, response);
		    }
		
	}

	private void guestLoginFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		 String guestName=request.getParameter("guestName");
		 String guestPass=request.getParameter("guestPass");
		 
		    int guestLength = guestName.length();
		    int guestPs = guestPass.length();
		 
    if ((4<=guestLength && guestLength <=16) && (4<=guestPs && guestPs <=16)){
		    	System.out.println("-----------Guest Login Filter 5555-------------");
		        // Allow the request to go to the next filter or target servlet
		        chain.doFilter(request, response);
		    } else {
		    	System.out.println("-----------Guest Login Filter 6666-------------");
		         String errorMessage = "Login failed. Please try again.";
		         request.setAttribute("errorMessage", errorMessage);
		         request.setAttribute("errorCode", "12-Return From LoginFilter");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				 dispatcher.forward(request, response);
		    }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
