package log4j.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/*
Output:

 Hello,World! 

13:37:58.542 [main] ERROR demo.Log4jDemo - Error!! 
13:37:58.545 [main] FATAL demo.Log4jDemo - Fatal!!
Completed
 * */

public class Log4jDemo {
	
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		String propFileloc = "./doc/log4j/log4j.properties";
		
		Properties prop=new Properties();
		FileInputStream fin = new FileInputStream(propFileloc);
		prop.load(fin);
		//PropertyConfigurator has been discontinued form Log4j2. Now programmatically log4j configurations is not allowed.
		PropertyConfigurator.configure(prop);
		Logger logger = LogManager.getLogger(Log4jDemo.class);		
		int num = 10;
		for(int i = 0; i < num; i++) {
			//Thread.sleep(10);
			logger.trace("This is a TRACE message.");
	        logger.debug("This is a DEBUG message.");
	        logger.info("This is an INFO message.");
	        logger.warn("This is a WARN message.");
	        logger.error("This is an ERROR message.");
	        logger.fatal("This is a FATAL message.");
		}
		System.out.println("Completed!!");
	}
}
