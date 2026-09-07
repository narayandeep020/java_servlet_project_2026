package com.management.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.management.dao.GuestDao;
import com.management.dto.GuestDTO;
import com.management.service.GuestService;
import com.management.util.AppUtil;

/**
 * Servlet implementation class GuestServlet
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet(description = "Guest Servlet", urlPatterns = { "/guest", "/viewByIdGuest", "/viewByNameGuest", "/createGuest", "/displayImageG", "/saveGuest",
		"/updateGuest", "/editGuest", "/deleteGuest", "/downloadImg" })

public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(GuestServlet.class);

       
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 logger.info("Method Name: doGet");

			String servletPath = request.getServletPath();
			System.out.println("servletPath "+servletPath);
			
			if("/viewByIdGuest".equals(servletPath)) {
				viewGuestById(request, response);
				
			}else if("/viewByNameGuest".equals(servletPath)) {
				viewGuestByName(request, response);
				
			}else if("/createGuest".equals(servletPath)) {
				createGuest(request, response);
				
			}else if("/displayImageG".equals(servletPath)){
				displayImage(request, response);
				
			}else if("/downloadImg".equals(servletPath)){
				downloadImages(request, response);
			}else {
				getGuestList(request, response);
			}
	}

	private void downloadImages(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: downloadImage");
		
	    String guestIdParam = request.getParameter("guestId");
	    int id = -1;

	    // Validate parameter
	    if (guestIdParam != null && !guestIdParam.trim().isEmpty()) {
	            id = Integer.parseInt(guestIdParam.trim());  
	    }else {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Guest ID is required.");
	        return;
	    }

	    // Fetch guest
	    GuestDTO guest = GuestDao.getGuestById(id);
	    if (guest != null && guest.getImage() != null) {
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Disposition", "attachment; filename=guest_" + id + ".jpg");

	        try (OutputStream out = response.getOutputStream()) {
	            out.write(guest.getImage());
	        }
	    } else {
	        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Guest or image not found.");
	    }
	}


	private void getGuestList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: getGuestList");
		
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		List<GuestDTO> list = GuestService.getGuestList();
		session.setAttribute("guestList", list);
		response.sendRedirect("guest.jsp");
	}

	private void displayImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: displayImage");
		
		response.setContentType("image/jpg");  
	    ServletOutputStream out;  
	    out = response.getOutputStream();  
	  
	    // 1. Define the relative path starting from the root of the classpath  
	    // file is inside src/main/resources under images folder 
	    
        String resourcePath = "images/sun_flower.jpg";
	    InputStream fin =  Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
	      
	    BufferedInputStream bin = new BufferedInputStream(fin);  
	    
	    BufferedOutputStream bout = new BufferedOutputStream(out);  
	    int ch =0; ;  
	    while((ch=bin.read())!=-1)  
	    {  
	    bout.write(ch);  
	    }  
	      
	    bin.close();  
	    fin.close();  
	    bout.close();  
	    out.close();  
	}

	private void createGuest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: Create Guest");
		
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		session.setAttribute("createGuest", "CREATE_GUEST");
		response.sendRedirect("guest.jsp");
	}

	private void viewGuestByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: viewGuestByName");
		
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String viewGuestName = request.getParameter("viewGuestName");
		List<GuestDTO> guestSearchList = null;
		if (viewGuestName != null) {
			guestSearchList = GuestService.getGuestByName(viewGuestName);
		}
		session.setAttribute("guestSearchList", guestSearchList);
		response.sendRedirect("guest.jsp");
	}

	private void viewGuestById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: View Guest By Name");
		
		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String viewGuestId = request.getParameter("viewGuestId");
		int guestId = 0;
		if (viewGuestId != null) {
			guestId = Integer.parseInt(viewGuestId);
		}

		GuestDTO guestObjByID = GuestService.getGuestById(guestId);

		session.setAttribute("guestObjByID", guestObjByID);
		response.sendRedirect("guest.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Method Name: doPost");
	
		String methodOverride = request.getParameter("_method");
		String editGuestId = request.getParameter("editGuestId");
		
		int updateGuestId = 0;
		if (editGuestId != null) {
			updateGuestId = Integer.parseInt(editGuestId);
		}
		
		if ("PUT".equalsIgnoreCase(methodOverride)) {
			// Manually forward the request and response to doPut
			logger.info("PUT Method");
			doPut(request, response);
			
		} else if ("DELETE".equalsIgnoreCase(methodOverride)) {
			// Manually forward the request and response to doDelete
			logger.info("DELETE Method");
			doDelete(request, response);
			
		} else if (updateGuestId > 0) {
			// Update record by post method
			logger.info("POST Method for update");
			updateGuestRecord(request, response);
			
		} else {
			// Create record by post method
			logger.info("POST Method for Create");
			saveGuestRecord(request, response);

		}
	}

	private void saveGuestRecord(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("Method Name: saveGuestRecord");
		
//      String guestName = (String) request.getAttribute("guestNameFromFilter");
		
		String guestName = request.getParameter("guestName");
		String guestEmail = request.getParameter("guestEmail");
		String guestPass = request.getParameter("guestPass");
		String country = request.getParameter("country");
		
		Part filePart = request.getPart("image");

        byte[] imageBytes = null;
        if (filePart != null) {
            InputStream inputStream = filePart.getInputStream();
            imageBytes = AppUtil.InputStreamToBytes(inputStream);
        }

		GuestDTO guest = new GuestDTO();
		guest.setGuestName(guestName);
		guest.setGuestEmail(guestEmail);
		guest.setGuestPass(guestPass);
		guest.setCountry(country);
		guest.setImage(imageBytes);
		

		int status = GuestService.addGuest(guest);
		System.out.println("status: " + status);
		logger.info("status  " + status);
		
		removeAttributes( request);
		
		HttpSession session = request.getSession(); // use existing session
		String insertMessage = null;

		if (status > 0) {
			insertMessage = "<p colour='#76D7C4'>Record inserted successfully.<p>";
		} else {
			insertMessage = "<p colour='#F1948A'>Sorry! unable to save record.<p>";
		}

		session.setAttribute("insertMessage", insertMessage);
		response.sendRedirect("guest.jsp");
		
	}

	private void updateGuestRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.info("Method Name: updateGuestRecord");
		
		String editGuestId = request.getParameter("editGuestId");
		int guestId = Integer.parseInt(editGuestId);

		// using through filter
//		String guestName = (String) request.getAttribute("guestNameFromFilter");

		// guestName direct from Form
		String guestName = request.getParameter("guestName");
		logger.info("Guest Name from form" + guestName);

		String guestEmail = request.getParameter("guestEmail");
		String guestPass = request.getParameter("guestPass");
		String country = request.getParameter("country");

		GuestDTO guest = new GuestDTO();
		guest.setGuestId(guestId);
		guest.setGuestName(guestName);
		guest.setGuestEmail(guestEmail);
		guest.setGuestPass(guestPass);
		guest.setCountry(country);

		int status = GuestService.updateGuest(guest);

		removeAttributes( request);
		HttpSession session = request.getSession(); // use existing session
		String updateMessage = null;

		if (status > 0) {
			updateMessage = "<p colour='#76D7C4'>Record updated successfully.<p>";
		} else {
			updateMessage = "<p colour='#F1948A'>Sorry! unable to update record.<p>";
		}

		session.setAttribute("updateMessage", updateMessage);
		response.sendRedirect("guest.jsp");
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Method Name: doPUT ");
        
        
		removeAttributes(request);
		
		HttpSession session = request.getSession(); // use existing session
		String guestId = request.getParameter("editGuestId");

		int id = Integer.parseInt(guestId);

		GuestDTO editGuestObj = GuestService.getGuestById(id);

		session.setAttribute("editGuestObj", editGuestObj);
		response.sendRedirect("guest.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("Method Name: doDelete");
		String deleteGuestId = request.getParameter("deleteGuestId");
		int guestId = Integer.parseInt(deleteGuestId);
		GuestService.deleteGuest(guestId);
		
		removeAttributes( request);
		
		HttpSession session = request.getSession(); // use existing session
		String deleteMessage = "<p colour='#76D7C4'>Record deleted successfully.<p>";;
		session.setAttribute("deleteMessage", deleteMessage);
		response.sendRedirect("guest.jsp");
	}

	private void removeAttributes(HttpServletRequest request) {
		logger.info("Method Name: removeAttribute");
		
		HttpSession session = request.getSession(false);

		 if (session != null) {
		     java.util.Enumeration<String> attributeNames = session.getAttributeNames();
		     while (attributeNames.hasMoreElements()) {
		         String attrName = attributeNames.nextElement();
		         session.removeAttribute(attrName);
		     }
		 }
	}

}
