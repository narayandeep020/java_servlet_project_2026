package com.listener;

import java.io.Serializable;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class AppSessionActivListener
 *
 */

@SuppressWarnings("serial")
@WebListener
public class AppSessionActivListener implements HttpSessionActivationListener, Serializable{

	private String name;
    /**
     * Default constructor. 
     */
    public AppSessionActivListener(String name) {
        // TODO Auto-generated constructor stub
    	this.name = name;
    }

    // ✅ Public no-arg constructor required
    public AppSessionActivListener() {
       
    }
	/**
     * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
     */
    public void sessionDidActivate(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("UserBean [" + name + "] has been activated. Session ID: " 
                + se.getSession().getId());
    }

	/**
     * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
     */
    public void sessionWillPassivate(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("UserBean [" + name + "] will be passivated. Session ID: " 
                + se.getSession().getId());
    }
    public String getName() {
    	return name;
    }
	
}
