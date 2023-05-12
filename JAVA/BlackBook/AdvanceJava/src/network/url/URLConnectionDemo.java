package network.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/*
Document properties.

Output:
	Content type: null
	Document date: Fri May 12 12:38:31 IST 2023
	Last modified: Thu Jan 01 05:30:00 IST 1970
	Document Expires: Thu Jan 01 05:30:00 IST 1970
	Content Length: 0
 * */

public class URLConnectionDemo {
	public static void main(String[] args) throws IOException {
		int character;
		URL url = new URL("http://www.oracle.com/technetwork/java/index.html");
		URLConnection  connection = url.openConnection();
		System.out.println("Content type: "+connection.getContentType());
		System.out.println("Document date: "+new Date(connection.getDate()));
		System.out.println("Last modified: "+new Date(connection.getLastModified()));
		System.out.println("Document Expires: "+new Date(connection.getExpiration()));
		int contentLength = connection.getContentLength();
		System.out.println("Content Length: "+contentLength);
		if(contentLength > 0) {
			InputStream in = connection.getInputStream();
			while((character = in.read()) != -1) {
				System.out.print((char)character);
			}
			in.close();
		}
	}
}
