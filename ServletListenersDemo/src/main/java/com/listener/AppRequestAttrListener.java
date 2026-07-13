package com.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppRequestAttrListener
 *
 */
@WebListener
public class AppRequestAttrListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public AppRequestAttrListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	 System.out.println(" Servlet Request Attribute Removed: " + srae.getName());
   	 
    }
	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	System.out.println(" Servlet Request Attribute Added: " + srae.getName());
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	  System.out.println(" Servlet Request Attribute Replaced: " + srae.getName());
    }
	
}
