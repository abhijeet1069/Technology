package network.url;

import java.net.MalformedURLException;
import java.net.URL;

/*

Shows details of URL.

Output:
	Protocol: http
	Port: 8080
	Host: www.example.com
	File: /path/
	Ext: http://www.example.com:8080/path/
 * */

public class URLDemo {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.example.com:8080/path/");
		System.out.println("Portocol: "+url.getProtocol());
		System.out.println("Port: "+url.getPort());
		System.out.println("Host: "+url.getHost());
		System.out.println("File: "+url.getFile());
		System.out.println("Ext: "+url.toExternalForm());
	}
}
