package markers;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class MyApp {
	 
    private static Logger logger = LogManager.getLogger(MyApp.class.getName());
    private static final Marker SQL_MARKER = MarkerManager.getMarker("SQL");
    private static final Marker UPDATE_MARKER = MarkerManager.getMarker("SQL_UPDATE").setParents(SQL_MARKER);
    private static final Marker QUERY_MARKER = MarkerManager.getMarker("SQL_QUERY").setParents(SQL_MARKER);
 
    public static String doQuery(String table) {
        logger.debug(QUERY_MARKER, "SELECT * FROM {}", table);
        String result = "doQuery() executed"; 
        return result;
    }
 
    public String doUpdate(String table, Map<String, String> params) {
        logger.traceEntry();
 
        if (logger.isDebugEnabled()) {
            logger.debug(UPDATE_MARKER, "UPDATE {} SET {}", table, formatCols(params));
        }
	
        String result = "doUpdate() executed"; 
 
        return logger.traceExit(result);
    }
 
    private String formatCols(Map<String, String> cols) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : cols.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	doQuery("start");
    }
}
