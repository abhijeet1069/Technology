package logging.customLogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lec3_CustomLogger {

	//properties via res/log4j2.xml
		private static Logger demoLogger = LogManager.getLogger(Lec3_CustomLogger.class.getName());
		
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
