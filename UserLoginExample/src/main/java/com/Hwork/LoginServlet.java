package com.Hwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpLoginDemo
 */
@WebServlet("/loginDemo")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 try{  
			  
		        response.setContentType("text/html");  
		        PrintWriter out = response.getWriter();  
		          
		        String name=request.getParameter("name");  
		        String password=request.getParameter("password");
		        
	            HttpSession session=request.getSession();
	            session.setAttribute("name",name);
		            
		        if(password.equals("admin123")){  
		            out.print("Welcome, "+name);
		            out.println("<br>"+"Login Successfully!");
		            out.print("<br>");
		            out.print("<a href='logout'>Logout</a>"); 
		            }else{  
		                out.print("Sorry, username or password error!"); 
		                out.print("<br><br>");
		                out.print(" <a href='/UserLoginExample/login.html' accesskey='1' title='Index Page'>Login</a>");
		            }  
		  
		         
		                  
		        out.close();  
		  
		                }catch(Exception e){System.out.println(e);}
	}

}
