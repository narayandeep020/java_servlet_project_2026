package com.techniques;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesHome
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
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
		      
		    Cookie ck[]=request.getCookies();  
//		    
//		    for(int i = 0; i < ck.length; i++) {  
//		        out.print("<br>" + ck[i].getName() + " " + ck[i].getValue());  
//		    }  
		    
		    out.print("Hello "+ck[0].getValue()); 
		    out.print("<br>Password is: "+ck[1].getValue());
		    out.print("<br>And your ID: "+ck[2].getValue());
		  
		    out.print("<br>");
		    out.print("<br>");
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
		    
		    String name = request.getParameter("userName");
		    String id = request.getParameter("userId");
		    
		    out.print("<br>");
			out.print("Home Servlet post method");
		  
		    out.print("<br>");
		    out.print("Hello: "+name +" Youe Id: [ "+id+" ]"); 
		    
		  
		    out.print("<br>");
		    out.print(" <a href='/SessionTracking/index.html' accesskey='1' title='Index Page'>Index Page</a>");
		    
		    out.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
