package com.management.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.management.util.EmailUtil;
import com.management.util.SmsUtil;

/**
 * Application Lifecycle Listener implementation class EmployeeListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        SmsUtil.sendSMS();
        EmailUtil.sendEmail();
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("Session Destroyed Here...!");
    }
	
}
