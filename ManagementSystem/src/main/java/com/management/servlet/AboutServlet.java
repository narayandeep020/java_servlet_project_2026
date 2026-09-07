package com.management.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.management.dao.AboutDao;
import com.management.dto.AboutDTO;



/**
 * Servlet implementation class AboutServlet
 */
@WebServlet("/about")
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private static final Logger logger = LoggerFactory.getLogger(AboutServlet.class);

	
    public AboutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("Method Name: doGet");
		
	            AboutDao dao = new AboutDao();
	            List<AboutDTO> aboutList = null;
	            
				try {
					aboutList = dao.getAllAboutSections();
				} catch (Exception e) {
					e.printStackTrace();
				}

	            // Debugging
	            System.out.println("Fetched sections: " + aboutList.size());

	            request.setAttribute("aboutList", aboutList);
	            RequestDispatcher rd = request.getRequestDispatcher("about.jsp");
	            rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
