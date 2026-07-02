 package com.techniques;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionDemo
 */
@WebServlet(description = "Http Session Program", urlPatterns = { "/userSession" })
public class HttpSessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpSessionDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
		    String guestName=request.getParameter("guestName");  
		    String guestPass=request.getParameter("guestPass");  
		    
		    BigDecimal big = new BigDecimal(Math.random());
		    big = big.setScale(4, RoundingMode.HALF_UP);
		    System.out.println(big);
		    
		    // if big = 0.1234 then  0.1234*10000+20 = 1254
		    int randomNum =(int) (big.doubleValue()*10000+20);
		    System.out.println(randomNum);
		    String guestId = "GUEST"+String.valueOf(randomNum);
		    
		    System.out.println("Guest Pass: "+guestPass);
		    
            HttpSession session = request.getSession();
           // create always new session
           // HttpSession sessionTrue = request.getSession(true);
           // Always use existing session
          // HttpSession sessionFalse = request.getSession(false);
            
            session.setAttribute("guestName", guestName);
            session.setAttribute("guestId", guestId);
		    
            ArrayList <Integer> numList = new ArrayList<>(); 
            
            numList.add(100); numList.add(200); numList.add(300);
            session.setAttribute("numList", numList);
		    
		    GuestDetail detail = new GuestDetail();
		    detail.setGuestName(guestName);
		    detail.setGuestCity("Maiher");
		    detail.setGuestId(guestId);
		    
		    session.setAttribute("GuestDetail", detail);
		    
		    out.print("<br>");
		    out.print("Welcome: "+guestName +" [ "+guestId+" ]"); 
		    
		    out.print("<br>");
		    out.print("<br>");

		  //appending the adminName in the query string  
	        out.print(" <a href='guest'>GuestPage</a>");
		    out.print("<br>");
		          
		    out.close(); 
		    
		}catch(Exception e) {
			System.out.println(e);		}
	}

}
