package xml;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class QueryCustomerInfo {
	public static void main(String []args) throws Exception{
	  	String responseString = "";
	    String outputString = "";
	    String wsURL = "http://10.95.90.19:8080/services/BcServices";// Endpoint of the webservice to be consumed
	    URL url = new URL(wsURL);
	    URLConnection connection = url.openConnection();
	    HttpURLConnection httpConn = (HttpURLConnection)connection;
	    ByteArrayOutputStream bout = new ByteArrayOutputStream();
	    BufferedReader br = new BufferedReader(new FileReader("input.xml"));
	    String xmlInput="", currLine;
	    while((currLine = br.readLine()) != null)
	    	xmlInput += currLine;
	    
	    //xmlInput = xmlInput.replace("MSISDN", "9791000643");  
	    //xmlInput = xmlInput.replace("MSISDN", "9791000644");
	    System.out.println("Input XML:\n"+xmlInput);
	    byte[] buffer = new byte[xmlInput.length()];
	    buffer = xmlInput.getBytes();
	    bout.write(buffer);
	    byte[] b = bout.toByteArray();
	    String SOAPAction = "QueryCustomerInfo"; // SOAP action of the webservice to be consumed
	    // Set the appropriate HTTP parameters.
	    //httpConn.setRequestProperty("Content-Length",String.valueOf(b.length));
	    httpConn.setRequestProperty("Content-Type", "text/xml");
	    httpConn.setRequestProperty("SOAPAction", SOAPAction);
	    httpConn.setRequestMethod("POST");
	    httpConn.setConnectTimeout(5000);
	    httpConn.setDoOutput(true);
	    httpConn.setDoInput(true);
	    OutputStream out = httpConn.getOutputStream();
	    //Write the content of the request to the outputstream of the HTTP Connection.
	    out.write(b);
	    out.close();
	    //Ready with sending the request.
	    int respCode = httpConn.getResponseCode();
	     System.out.println("\n\nResponse Code: "+respCode);
	    //Read the response.
	    InputStreamReader isr = null;
	    if (respCode == 200) {
	    	System.out.println("Reading from input stream "+respCode);
	      isr = new InputStreamReader(httpConn.getInputStream());
	    } else {
	    	System.out.println("Reading from error stream "+respCode);
	      isr = new InputStreamReader(httpConn.getErrorStream());
	    }
	    
	    BufferedReader in = new BufferedReader(isr);
	     
	    //Write the SOAP message response to a String.
	    while ((responseString = in.readLine()) != null) {
	        outputString = outputString + responseString;
	    }
	    System.out.println("\nOutput XML:");
	    System.out.println(outputString);
	    
	    /*Convert string to XML in memory and read required tags */
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(outputString));
		Document doc = docBuilder.parse(is);
		doc.normalize();

		//Fetching main balance
		Node balanceResultNode = doc.getElementsByTagName("bcs:BalanceResult").item(0);
		if(balanceResultNode.getNodeType() == Node.ELEMENT_NODE){
			Node totalAmountNode = ((Element)balanceResultNode).getElementsByTagName("bcs:TotalAmount").item(0);
			if(totalAmountNode.getNodeType() == Node.ELEMENT_NODE){
				Long amount = Long.parseLong(totalAmountNode.getTextContent());
				amount = amount/100;
				System.out.println("Total Amount: "+amount+" Kyats");
			}
			else
				System.out.println("Unable to fetch tag: <bcs:TotalAmount>");
		}
		else
			System.out.println("Unable to fetch tag: <bcs:BalanceResult>");
		
		//Fetching validity
		Node lifeCycleDetailNode = doc.getElementsByTagName("bcs:LifeCycleDetail").item(0);
		if(lifeCycleDetailNode.getNodeType() == Node.ELEMENT_NODE){
			NodeList lifeCycleStatusNodeList = ((Element)lifeCycleDetailNode).getElementsByTagName("bcs:LifeCycleStatus");
			int lifeCycleStatusNodeListCount = lifeCycleStatusNodeList.getLength();
			if(lifeCycleStatusNodeListCount >= 1){
				String statusName="",expireTime="";
				for(int i = 0; i < lifeCycleStatusNodeListCount; i++){
					statusName= ((Element)lifeCycleStatusNodeList.item(i)).getElementsByTagName("bcs:StatusName").item(0).getTextContent();
					expireTime = ((Element)lifeCycleStatusNodeList.item(i)).getElementsByTagName("bcs:StatusExpireTime").item(0).getTextContent();
					if(statusName.equalsIgnoreCase("Active")){
						if(expireTime.length()>=8)
							expireTime = expireTime.substring(6,8)+"/"+expireTime.substring(4,6)+"/"+expireTime.substring(0,4);
						else
							expireTime="";
						break;
					}
						
				}
				System.out.println("Expire Time: "+expireTime);
			}
			else
				System.out.println("Unable to fetch tag: <bcs:LifeCycleStatus>");
		}
		else
			System.out.println("Unable to fetch tag: <bcs:LifeCycleDetail>");
  }
}
