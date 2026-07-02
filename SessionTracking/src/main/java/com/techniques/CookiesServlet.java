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
 * Servlet implementation class CookiesServlet
 */
@WebServlet(description = "Cookies Techniques", urlPatterns = { "/cookies" })
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try{  
			  
			    response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			          
			    String n=request.getParameter("userName");
			    String p=request.getParameter("password");
			    String userId=request.getParameter("userId");
			    
			    out.print("Cookies Tracking Techniques");
			    out.print("<br>");
			    out.print("Welcome "+n+"<br> Your ID: "+ userId);  
			  
			    Cookie user=new Cookie("userName",n);//creating cookie object
			    Cookie pass=new Cookie("password",p);
			    Cookie id=new Cookie("userId",userId);
			    
			    response.addCookie(user);//adding cookie in the response  
			    response.addCookie(pass);
			    response.addCookie(id);
			    
			    out.print("<br><br/>");
			  
			    //creating submit button  
			    out.print("<form action='Home' method='get'>");  
			    out.print("<input type='submit' value='goHome'>");  
			    out.print("</form>");  
			          
			    out.close();  
			  
			        }catch(Exception e){System.out.println(e);}  
			  }  

}
