package logging.fileLogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
Logs example:

20-05-2023 17:43:14.482 [main] [12] [Lec4_FileLogger.java] INFO  - Click successful
20-05-2023 17:43:14.483 [main] [13] [Lec4_FileLogger.java] WARN  - Click successful
20-05-2023 17:43:14.483 [main] [14] [Lec4_FileLogger.java] DEBUG - Click successful
20-05-2023 17:43:14.483 [main] [16] [Lec4_FileLogger.java] INFO  - Click successful
 * */

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
