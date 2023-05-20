package logging;

/*
Standard Level		intLevel
	OFF				0
	FATAL			100
	ERROR			200    //If we provide error,then only above levels will be logged.
	WARN			300
	INFO			400
	DEBUG			500
	TRACE			600
	ALL				Integer.MAX_VALUE
 * */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lec2_Log4jConfig {

	//properties via res/log4j2.xml
	private static Logger demoLogger = LogManager.getLogger(Lec2_Log4jConfig.class.getName());
	
	public static void main(String[] args) {
		System.out.println("Hello, World!!");	
		demoLogger.info("Click successful");
		demoLogger.warn("Click successful"); //only standard level above error message displayed in console, not below it like info and debug
		demoLogger.debug("Click successful");

	}

}
