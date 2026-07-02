package com.techniques;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuestServlet
 */
@WebServlet("/guest")
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
		    PrintWriter out = response.getWriter(); 
		    
		    HttpSession session = request.getSession(false);
		    
		    String guestName=(String)session.getAttribute("guestName");  
	        String guestId =(String)session.getAttribute("guestId");
	        
	        out.print("Welcome "+guestName +"[ "+guestId+" ]"); 
	        out.print("<br>");
			out.print("<br>");
			 
			 ArrayList<Integer> listNum = (ArrayList<Integer>) session.getAttribute("numList");
			 for(Integer num: listNum) {
				 System.out.println(num);
			 }
			 
			 GuestDetail gDetail = (GuestDetail) session.getAttribute("GuestDetail");
			 out.print("Guest Servlet get method");
			 
			 if (gDetail == null) {
				    System.out.println("gDetail is null!");
				}
			 out.print("<br>");
			 out.print("Guest_Name: "+gDetail.getGuestName()); 
			 out.print("<br>");	  
			 out.print("Guest_City: "+gDetail.getGuestCity()); 
			 out.print("<br>");
			 out.print("Guest_Id: "+gDetail.getGuestId()); 
		     out.print("<br>");
		      
		     
		    out.print("<br>");
		    out.print("<br>");
		    out.print(" <a href='/SessionTracking/index.html' accesskey='1' title='Index Page'>IndexPage</a>");
			    
			    out.close();
			 
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
