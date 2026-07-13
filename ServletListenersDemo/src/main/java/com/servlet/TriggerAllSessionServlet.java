package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class TriggerAllServlet
 */
@WebServlet("/TriggerAllServlet")
public class TriggerAllSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TriggerAllSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<h2>Triggering all Session listeners...</h2>");

	        // Session lifecycle + attributes
	        HttpSession session = request.getSession(true);
	        session.setAttribute("user", "Deep");
	        session.setAttribute("user", "Updated");
	        session.removeAttribute("user");
	        session.invalidate();

	        // Request lifecycle fires automatically at start/end

	        out.println("<p>Check Tomcat logs to see each listener firing separately.</p><br/>");
	        
	        out.println("<a href='/ServletListenersDemo/index.html'>index page</a> "); 
	        
	        
	}

}
