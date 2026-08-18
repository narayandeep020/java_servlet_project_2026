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
 * Servlet Filter implementation class EmpLoginFilter
 */
@WebFilter(description = "EmployeeLoginFilter", urlPatterns = { "/empLoginServlet" })
public class EmpLoginFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public EmpLoginFilter() {
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
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		
		String empName = request.getParameter("empName");
        String password = request.getParameter("password");
        
        int empLength = empName.length();
        int passLength = password.length();

            if (empLength <= 10 && passLength <= 8) {
                // Forward request to servlet
                chain.doFilter(request, response);
                
                System.out.println("length of empName is: "+empLength);
                System.out.println("length of password is: "+passLength);

                
            } else {
                // Show error message         	
        	    System.out.print(" empName and Password More then 8 charactor!");   
        	    RequestDispatcher rd=request.getRequestDispatcher("empDash.jsp");  
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
