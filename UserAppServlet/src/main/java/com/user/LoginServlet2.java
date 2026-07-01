package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
//@WebServlet("/login")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 try{  
			  
		        response.setContentType("text/html");  
		        PrintWriter out = response.getWriter();  
		          
		        String userName=request.getParameter("username");  
		        String address=request.getParameter("address");  
		        String age=request.getParameter("age"); 
		        out.println("Welcome to login screen: "); 
		        out.print("<br>Welcome "+userName); 
		        out.print("<br>Your address: "+address);
		        out.print("<br>And your age: "+age); 
		        
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
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("username");  
	    String p=request.getParameter("userpass");  
	    
	    if(p.equals("welcome")) {
	    	RequestDispatcher rd = request.getRequestDispatcher("/welcome");
	    	rd.forward(request, response);
	    }else if(p.equals("admin")) {
	    	RequestDispatcher rd = request.getRequestDispatcher("/admin");
	    	rd.forward(request, response);
	    }
	    else {
	    	out.println("Warning! Username and Password Error."+n);
	    	out.println("<br> Include login servlet content");
	    	RequestDispatcher rd = request.getRequestDispatcher("index.html");
	    	rd.include(request, response);
	    }
	}

}
