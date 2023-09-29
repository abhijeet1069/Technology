package api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {
	
	private static final Logger logger = LogManager.getLogger(HelloWorld.class);
	
	public static void main(String[] args) throws InterruptedException {
	
	System.out.println(logger.getName()+" started!!");
	logger.debug("This is a DEBUG message");
	System.out.println(logger.getName()+" completed!!");
	}
}
