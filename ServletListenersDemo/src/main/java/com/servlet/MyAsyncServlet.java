package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listener.MyAsyncListener;

/**
 * Servlet implementation class AttributeServlet
 */
@WebServlet(urlPatterns = "/servlet3", asyncSupported = true)

//@WebServlet("/servlet3")
public class MyAsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAsyncServlet() {
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
	        
	        out.print("<h2>Triggering Async listeners...</h2>");

	        // Put request in async mode
	        AsyncContext asyncContext = request.startAsync();

	        // Attach our separate listener class
	        asyncContext.addListener(new MyAsyncListener());

	        // Simulate background work
	        asyncContext.start(() -> {
	            try {
	                Thread.sleep(1000); // simulate delay
	                out.println("<h2>Async work done!</h2>");
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                asyncContext.complete(); // triggers onComplete()
	            }
	        });
		   
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
