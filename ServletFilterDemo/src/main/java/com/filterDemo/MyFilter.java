package com.filterDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterDemo
 */
@WebFilter(description = "Filter Demo Program", urlPatterns = { "/hello","/HelloServlet"})
public class MyFilter extends HttpFilter implements Filter {
 
	private static final long serialVersionUID = 1L;



    public MyFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 System.out.println("Filter initialized");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 // Pre-processing logic
        out.println("Request received at filter");

        // Pass request along the filter chain
        chain.doFilter(request, response);
        
        // Post-processing logic
        out.println("<br>Response leaving filter");
        
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void destroy() {
		 System.out.println("Filter destroyed");
	}

}
