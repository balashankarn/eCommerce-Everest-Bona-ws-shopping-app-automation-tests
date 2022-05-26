package com.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggerClass {

    //Initialize Log4j logs
	private static final Logger logger = LoggerFactory.getLogger(LoggerClass.class);

	  public static void main(String[] args) {
		  logger.info("Start of application");
	      logger.info("End of application");
	      logger.error("This is an error ");
	    }
	}
