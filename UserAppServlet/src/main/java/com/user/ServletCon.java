package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCon
 */
//@WebServlet("/ServletCon")
public class ServletCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		      
		    // Servlet Config Object  Scope ---Within servlet
		    ServletConfig config=getServletConfig();  
		    Enumeration<String> e=config.getInitParameterNames();  
		          
		    String str="";  
		    while(e.hasMoreElements()){  
		    str=e.nextElement();  
		    out.print("<br>Name: "+str);  
		    out.print("<br>value: "+config.getInitParameter(str));  
		    }  
		    out.print("<br><br>");
		    
		    out.print("======================================="); 
		    // Servlet Context Scope --Global
		    
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
