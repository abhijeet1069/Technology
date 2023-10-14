# Log4J Core components:

## Loggers:
Each logger is associated with a specific name and configured to log messages at a specific level of severity (e.g., DEBUG, INFO, ERROR). 
Loggers are organized in a hierarchical namespace, where loggers inherit settings and configurations from their parent loggers.

Calling the LogManager.getLogger method with the same name will always return a reference to the exact same Logger object.
For example, in
	Logger x = LogManager.getLogger("wombat");
	Logger y = LogManager.getLogger("wombat");
	x and y refer to exactly the same Logger object.
Naming loggers after the class where they are located seems to be the best strategy known so far.

## Appenders
Appenders are responsible for outputting log messages to various destinations, such as console, files, databases, or remote services. 
Log4j provides various built-in appenders like ConsoleAppender, FileAppender, and SocketAppender.

## Layouts
Layouts: Layouts determine the format of log messages. Log4j provides several built-in layouts, including 
	PatternLayout (which allows you to specify a format using placeholders)
	JSONLayout (for JSON-formatted logs)
	HTMLLayout (for HTML-formatted logs). 
	Custom layouts can also be created if needed.

## Filters
Filters are used to selectively control which log messages are actually logged. Filters can be attached to appenders or loggers, allowing you to fine-tune 
the logging behavior based on message content, log level, or other criteria.

## Configurations
Log4j configurations specify how logging should be performed. There are multiple ways to configure Log4j, including through XML, properties files, and 
programmatic configuration using code. Configuration files can define loggers, appenders, layouts, and filter settings.

## Log levels
Above log levels are not logged.
	TRACE
	DEBUG
	INFO
	WARN
	ERROR
	FATAL
	
## Log Manager 
The LogManager is responsible for managing loggers and their configurations. It initializes the logging system, loads configuration files, and provides access to loggers.

## Log Context
Log4j allows you to include contextual information in log messages, such as thread information, date and time, and custom properties. This context information can be useful for debugging and troubleshooting.

## Plugins and Extensions
Log4j supports the use of plugins and extensions, including custom appenders, layouts, and filters. This extensibility allows you to tailor Log4j to meet your specific logging requirements.

## Async Logging (Optional): 
Log4j supports asynchronous logging, which can improve application performance by off-loading the logging work to a separate thread. Asynchronous logging is an optional feature and can be configured based on your application's needs.