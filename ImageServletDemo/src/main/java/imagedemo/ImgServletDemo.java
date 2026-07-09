package imagedemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ImgServletDemo
 */
@WebServlet(description = "Image Servlet Demo", urlPatterns = { "/imgdemo" })

@MultipartConfig(maxFileSize = 16177215)

public class ImgServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgServletDemo() {
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
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		PrintWriter out = response.getWriter();
		
		InputStream input = null;
		String message = null;
		
		Part filePart = request.getPart("photo");
		
		if(filePart != null) {
			
			System.out.println(filePart.getName()); 
            System.out.println(filePart.getSize());
            System.out.println( filePart.getContentType());

		    // Obtains input stream of the upload file		            
		    input = filePart.getInputStream();
		}
		int row = ImageDao.uploadFile(firstName, lastName, input);
		if(row>0) {
			message = "File uploaded and saved into database";
		}
		System.out.println(message);
		out.print("Image uploaded successfully");
		out.print("<br/>");
		out.print("<a href='/ImageServletDemo/index.html'>index page</a>");
		
	}

}
