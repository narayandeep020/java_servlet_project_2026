package com.listener;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyAsyncListener
 *
 */
@WebListener
public class MyAsyncListener implements AsyncListener {
    /**
     * Default constructor. 
     */
    public MyAsyncListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see AsyncListener#onComplete(AsyncEvent)
     */
    public void onComplete(AsyncEvent arg0) throws java.io.IOException { 
         // TODO Auto-generated method stub
    	System.out.println("Async Completed for request: " + arg0.getAsyncContext().getRequest());
    }

	/**
     * @see AsyncListener#onError(AsyncEvent)
     */
    public void onError(AsyncEvent arg0) throws java.io.IOException { 
         // TODO Auto-generated method stub
    	System.out.println("Async Error: " + arg0.getThrowable());
    }

	/**
     * @see AsyncListener#onStartAsync(AsyncEvent)
     */
    public void onStartAsync(AsyncEvent arg0) throws java.io.IOException { 
         // TODO Auto-generated method stub
    	System.out.println("Async Started Again");
    }

	/**
     * @see AsyncListener#onTimeout(AsyncEvent)
     */
    public void onTimeout(AsyncEvent arg0) throws java.io.IOException { 
         // TODO Auto-generated method stub
    	System.out.println("Async Timeout occurred!");
    }
	
}
