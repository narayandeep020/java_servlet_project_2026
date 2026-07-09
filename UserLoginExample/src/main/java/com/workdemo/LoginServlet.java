package com.workdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		        String inputPassword=request.getParameter("password");
		        
		        System.out.println("input password: "+inputPassword);
	            
	            String fromPasswordDb = getPasswordFormDb(name);
	            
	            System.out.println("input Dbpassword: "+fromPasswordDb);
	            
		            
		        if(inputPassword.equals(fromPasswordDb)){ 
		        	
		        	 HttpSession session=request.getSession();
			         session.setAttribute("name",name);
		        	
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

	public String getPasswordFormDb(String name) {
		 String password = null;
	        try (Connection con = DbConnection.getConnection()) {
	            String sql = "SELECT pass_word FROM users WHERE username = ?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, name);

	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                password = rs.getString("pass_word");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return password;
	}

}
