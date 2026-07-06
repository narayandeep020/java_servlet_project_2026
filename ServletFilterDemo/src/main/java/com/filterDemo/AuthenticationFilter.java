package com.filterDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(
	    urlPatterns = { "/admin"},
	    initParams = {
	        @WebInitParam(name = "adminUser", value = "Ashoka"),
	        @WebInitParam(name = "adminPass", value = "admin123")
	    }
	)

public class AuthenticationFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  private String adminUser;
	  private String adminPass;
	
	  
    public AuthenticationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AuthenticationFilter init method");
		
		this.adminUser = fConfig.getInitParameter("adminUser");
		this.adminPass = fConfig.getInitParameter("adminPass");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.print("<p>AutheonticationFilter filter method invoked.</p>");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
	
		
	    if(name.equals(this.adminUser) && password.equals(this.adminPass)){  
	    out.print("Login Success..!");
	    request.setAttribute("adminUser", this.adminUser);
	    chain.doFilter(request, response);//sends request to next resource  
	    }  
	    else{  
	    out.print("   username or password error!");   
	    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	    rd.include(request, response);  
	    }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void destroy() {
		System.out.println("AuthenticationFilter destroy method");
	}

}
