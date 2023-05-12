package network.addressResolution;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


/*
InetAddress: Provides the efficiency of caching successful and unsuccessful resolutions of host-name
			Internet address is cached in a hierarchical series of cached servers. It is advisable to structure your code so that
			you cache IP address information locally rather than viewing it repeatedly.

Commonly used factory methods:
	static InetAddress getbyName(String host)  
	throws UnknownHostException  
	static InetAddress getLocalHost()  
	throws UnknownHostException  
	static InetAddress[] getAllbyName(String host) - Enter hostname and it returns IP address
	throws UnknownHostException  
 * */

public class InetAddressHosting {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws UnknownHostException {
		String host;
		System.out.print("\nHost Name? ");
		host = sc.nextLine();
		try {
			InetAddress[] addresses = InetAddress.getAllByName(host);
			for(InetAddress ip : addresses) {
				System.out.println(ip.toString());
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
