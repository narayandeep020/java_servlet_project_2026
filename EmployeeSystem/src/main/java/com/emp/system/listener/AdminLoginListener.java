package com.emp.system.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AdminLoginListener
 *
 */
@WebListener
public class AdminLoginListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public AdminLoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	
    	sentTextSMS();
    }

	private void sentTextSMS() {
		// TODO Auto-generated method stub
	System.out.println("sendTextSMS method called on HttpSession event in AdminLogin");	
	}

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
