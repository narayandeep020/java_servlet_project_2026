package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
//@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String userName=request.getParameter("username");  
		    out.print("Hello "+userName+" this is welcome servlet page");
		    out.println("<br>======================================<br>");
		    
		    ServletContext context=getServletContext();  
		    Enumeration<String> contextEnum=context.getInitParameterNames();  
		          
		    String str2="";  
		    while(contextEnum.hasMoreElements()){  
		    	str2=contextEnum.nextElement();  
		    	out.print("<br>Name: "+str2);  
		        out.print("<br>value: "+context.getInitParameter(str2));  
		    }  
		    out.close();
	}

}
