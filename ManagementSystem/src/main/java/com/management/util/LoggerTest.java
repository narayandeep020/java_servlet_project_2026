package com.management.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerTest {
	  
	private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

	public static void main(String[] args) {
		
		logger.info("Application started");
        logger.debug("Debugging details here...");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        System.out.println("Check E:/application_secret/app.log for log output");

	}

}
