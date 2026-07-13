package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/servlet1")
public class TriggerAllContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TriggerAllContextServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<h2>Triggering all Context listeners...</h2>");

	        // Context attribute events
	        ServletContext context = getServletContext();
	        context.setAttribute("ctxAttr", "value1");
	        context.setAttribute("ctxAttr", "value2");
	        context.removeAttribute("ctxAttr");
	        
	        out.println("<p>Check Tomcat logs to see each listener firing separately.</p><br/>");
	        
	        out.println("<a href='/ServletListenersDemo/index.html'>index page</a> ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
