package com.emp.system.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



/**
 * Application Lifecycle Listener implementation class EmpLoginListener
 *
 */
@WebListener
public class EmpLoginListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public EmpLoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  {
    	
    	sendEmail();
    	sendTextSms();
    }

    private void sendTextSms() {
    	System.out.println("sendTextSms method called on HttpSession event in EmpLogin");
		
	}

	private void sendEmail() {
        System.out.println("sendEmail() method called on HttpSession event in EmpLogin");
    }

	
    public void sessionDestroyed(HttpSessionEvent se) { 
         // TODO Auto-generated method stub
    }
 
	
}
