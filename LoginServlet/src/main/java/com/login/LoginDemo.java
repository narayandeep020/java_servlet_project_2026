package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginDemo
 */
@WebServlet("/LoginDemo")
public class LoginDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("<h4>Servlet Project Example</h4> ").append(request.getContextPath());
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Deploy HTML file
//        RequestDispatcher rd = request.getRequestDispatcher("login.html");
//        rd.forward(request, response);

        // Get form data
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Simple validation
        out.println("<html><body>");
        if ("admin".equals(user) && "admin123".equals(pass)) {
            out.println("<h2>Login Successful!</h2>");
        } else {
            out.println("<h2>Invalid Username or Password</h2>");
        }
        out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);

}
    }
