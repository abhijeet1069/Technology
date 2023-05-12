package network.socket;

import java.net.*;  
import java.io.*;  

/*First run ServerCode.java*/

class ClientCode  { 
	public static void main(String args[]) throws Exception  {  
		int character;  
		Socket socket = new Socket("127.0.0.1", 8765);  
		InputStream in = socket.getInputStream();  
		OutputStream out = socket.getOutputStream();  
		String string = "Dreamtech Press!\n";  
		byte buffer[] = string.getBytes();  
		out.write(buffer);  
		while ((character = in.read()) != -1)  {  
			System.out.print((char) character);  
			}  
		socket.close();  
		} 
	} 
 

