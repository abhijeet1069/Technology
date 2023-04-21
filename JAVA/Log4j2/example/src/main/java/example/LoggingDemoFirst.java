package example;

import org.apache.logging.log4j.*;

public class LoggingDemoFirst {
	private static Logger demologger = LogManager.getLogger(LoggingDemoFirst.class.getName());
	public static void main(String[] args) {
		demologger.info("Hello,World");
		demologger.error("DB connection");
		demologger.debug("This is debug");
	}

}
