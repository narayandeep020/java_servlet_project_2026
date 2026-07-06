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
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class PreProcessFilter
 */
@WebFilter(description = "PreProcessing Filter", urlPatterns = { "/prehello" },
initParams = {
		@WebInitParam(name = "environment", value = "production"),
		@WebInitParam(name = "max-tries", value = "5")
})
public class PreProcessFilter extends HttpFilter implements Filter {
       
	private String environment;
	@SuppressWarnings("unused")
	private int maxTries;
  
	private static final long serialVersionUID =1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public PreProcessFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("PreProcessFilter destroy method invoke");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
	    out.print("PreProcessFilter doFilter method is invoked");  
	    out.print("<br/>"); 
	    
	    request.setAttribute("envParam", this.environment);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("PreProcessFilter init method invoked");
		
		this.environment = fConfig.getInitParameter("environment");
		String retries = fConfig.getInitParameter("max-tries");
		if(retries != null)
			this.maxTries = Integer.parseInt(retries);
	}

}
