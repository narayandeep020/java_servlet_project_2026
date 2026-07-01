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
 * Servlet implementation class AdminServlet
 */
//@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String pathInfo = request.getPathInfo();
			
			if(pathInfo == null || "/".equals(pathInfo)) {
				System.out.println("path parameter required");
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing path parameter required");
	            return;
	        }
			
			String username = null;
			String address = null;
			String age = null;
			
			 // Array looks like: ["", "username", "address","age"]--> it starts with a slash index 0 ->/
	        String[] pathParts = pathInfo.split("/"); 
	        
	        if (pathParts.length > 1) {
	             username = pathParts[1]; // Retrieves "Username"
	             address = pathParts[2]; // Retrieves "Address"
	             age = pathParts[3]; // Retrieves "Age"
	           
	            System.out.println("userName is: " + username);  
	            System.out.println("address is: " + address);
	            System.out.println("age is: " + age);
	        }
	        out.print("Welcome to admin screen "+username); 
	        out.print("<br/> This is your address: "+address);  
	        out.print("<br/> And your age: "+age); 
	        
	        out.close(); 
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter out= response.getWriter();
		 
		 out.print("<html> <body> This is admin servlet page</body></html>");
		 out.print("<br>=====================================<br>");
		 
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
