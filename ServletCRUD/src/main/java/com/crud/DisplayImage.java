package com.crud;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayImage
 */
@WebServlet("/image")
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpg");
		ServletOutputStream out = response.getOutputStream();
		
		String resourcePath = "image/As man thinking.jpg";
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
		
	    BufferedInputStream bin = new BufferedInputStream(input);  
	    
	    BufferedOutputStream bout = new BufferedOutputStream(out); 
	    
	   int ch = 0;
	   while((ch = bin.read()) != -1) {
		   bout.write(ch);
	   }
	   input.close();
	   bin.close();
	   bout.close();
	   out.close();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
