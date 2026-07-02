package com.techniques;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenFormServlet
 */
@WebServlet("/Hidden")
public class HiddenFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		  try{  
			  
		        response.setContentType("text/html");  
		        PrintWriter out = response.getWriter();  
		        out.print("<br>");
		        //getting value from the query string  
		        String n=request.getParameter("uname");  
		        out.print("Hello "+n);
		        
		        out.print("<br><br>");
		        out.print(" <a href='/SessionTracking/index.html' accesskey='1' title='Index Page'>Index Page</a>");
		  
		        out.close();  
		  
		                }catch(Exception e){System.out.println(e);}  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		 response.setContentType("text/html");  
	     PrintWriter out = response.getWriter();  
	          
	     String n=request.getParameter("userName"); 
	     String id=request.getParameter("userId");
	     
	     System.out.println("Client Name: "+n);
	     out.print("<br>");
	     
	     out.print("Welcome "+n+" ["+id+"]");
	     out.print("<br>");
	     
	     
		    out.print("<form action='Home' method='post'>");  
		    out.print("<input type='submit' value='Home'>");  
		    out.print("<input type='hidden' name='userId' value='"+id+"'>");
		    out.print("<input type='hidden' name='userName' value='"+n+"'>");
		    out.print("</form>");  
		    out.print("<br>");
	 
		    out.close();
		    
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
