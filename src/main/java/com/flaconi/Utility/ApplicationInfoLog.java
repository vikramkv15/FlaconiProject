package com.flaconi.Utility;

import org.apache.log4j.Logger;

public class ApplicationInfoLog {
	
	Logger log = Logger.getLogger("devpinoyLogger");
	
	public static void loggingInfo(Logger log, String message) {
		log.debug(message);
		System.out.println(message);
		
	}
	
}
