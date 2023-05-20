package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
Output: 
	Hello, World!!
	11:56:42.778 [main] ERROR log4j.Lec1_LoggingViaLog4j - Click successful
 * */

public class Lec1_LoggingViaLog4j {

	private static Logger demoLogger = LogManager.getLogger(Lec1_LoggingViaLog4j.class.getName());
	
	public static void main(String[] args) {
		System.out.println("Hello, World!!");	
		demoLogger.info("Click successful");
		demoLogger.error("Click successful"); //only error message displayed in console, not info and debug
		demoLogger.debug("Click successful");
	}
}
