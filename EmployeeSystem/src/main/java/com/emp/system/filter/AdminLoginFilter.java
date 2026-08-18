package com.emp.system.filter;

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

/**
 * Servlet Filter implementation class AdminLoginFilter
 */
@WebFilter(description = "Admin Login Filter", urlPatterns = { "/adminLoginFilter" })
public class AdminLoginFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public AdminLoginFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		
		String adminName = request.getParameter("adminName");
        String adminPass = request.getParameter("adminpass");
        
        int adminLength = adminName.length();
        int passLength = adminPass.length();

            if (adminLength <= 10 && passLength <= 8) {
                // Forward request to servlet
                chain.doFilter(request, response);
                
                System.out.println("length of adminName is: "+adminLength);
                System.out.println("length of adminPass is: "+passLength);

                
            } else {
                // Show error message         	
        	    System.out.print(" adminName and Password More then 8 charactor!");   
        	    RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
        	    rd.include(request, response);
            }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
