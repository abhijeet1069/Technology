package log4j.fileLogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lec4_FileLogger {

	private static Logger demoLogger = LogManager.getLogger(Lec4_FileLogger.class.getName());
	
	public static void main(String[] args) {
		System.out.println("Hello, World!!");	
		demoLogger.info("Click successful");
		demoLogger.warn("Click successful"); //only standard level above error message displayed in console, not below it like info and debug
		demoLogger.debug("Click successful");
		System.out.println("Hello, World!!");	
		demoLogger.info("Click successful");
		demoLogger.warn("Click successful"); 
		demoLogger.debug("Click successful");
		System.out.println("Hello, World!!");	
		demoLogger.info("Click successful");
		demoLogger.warn("Click successful");
		demoLogger.debug("Click successful");

	}

}
