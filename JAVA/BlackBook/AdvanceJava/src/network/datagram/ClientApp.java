package network.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientApp {

	public static int serverPort = 997;
	public static int clientPort = 998;
	
	public static int buffer_size = 1024;
	public static DatagramSocket ds;
	public static byte[] buffer = new byte[buffer_size];
	
	public static void client() throws Exception{
		while(true) {
			DatagramPacket p = new DatagramPacket(buffer,buffer.length);
			ds.receive(p);
			System.out.println(new String(p.getData(),0,p.getLength()));
		}
	}
	
	public static void main(String[] args) throws Exception {
		ds = new DatagramSocket(clientPort);
		client();

	}

}
