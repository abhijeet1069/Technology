package network.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
Write on server app and text is displayed on client window.
 * */

public class ServerApp {

	public static int serverPort = 997;
	public static int clientPort = 998;
	public static int bufferSize = 1024;
	public static DatagramSocket ds;
	public static byte[] buffer = new byte[bufferSize];
	
	public static void Server() throws Exception{
		int pos = 0;
		while(true) {
			int c = System.in.read();
			switch(c) {
			case -1 : System.out.println("Server Quits!!");
					  return;
					  
			case '\r' : break;
			
			case '\n' : ds.send(new DatagramPacket(buffer,pos,InetAddress.getLocalHost(), clientPort));
			            break;
			default : buffer[pos++] = (byte)c;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		ds = new DatagramSocket(serverPort);
		Server();

	}

}
