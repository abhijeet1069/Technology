package intro;

import java.nio.charset.Charset;
import java.util.Arrays;


/*	1) Strings are immutable.
 	Note - The fastest way of concatenating strings is to create StringBuilder once and reuse same instance inside the loop
 
	2) Comparing Strings : 
		boolean str1.equals(str2) - True if strings content are equal, and false if strings are unequal
		boolean str1.equalsIgnoreCase(str2) - Compares two strings content ignoring content
		boolean str1.startWith(str2)
		boolean str1.endsWith(str2)
		int str1.compareTo(str2) - compares a string content to another string content and return an integer 
								   telling whether a string is smaller, equal or larger than other string.
 
 	3)	Trimming Strings :
 			String str1.trim() - removes white space characters at the beginning and end of the string.
 	
 	4)  Splitting strings with split : 
 	 		String[] split(" ")
 	 		
 	5)  Converting numbers to Strings with valueOf() :
 			String.valueOf(10) - convert a number to a String.
 			
 	6) Converting objects to strings :
 		Integer integer = new Integer(123);
 		String str = integer.toString(); //Many built-in Java classes have a sensible toString() method already 		
 */

public class Strings_2 {
	/*
	 7) Replacing characters in String
	  	String str1.replace('a','b'); - replaces all the occurrence of 'a' with 'b'
	  	String str1.replaceAll('a','b'); - replaces all the occurrence of 'a' with 'b', regex in enabled here
	  	String str1.replaceFirst()
	 */
	public static void replaceString(String source, String findWhat, String replaceWith) {
		System.out.println(source.replace(findWhat, replaceWith));
	}
	
	/*
	 8) Getting Characters and Bytes:
		str.charAt(0) - Fetch character from str 0th position
		byte[] bytes = str.getBytes(); //String to byte array
	 */
	public static void testChar(String str) {
		byte[] byteArr = str.getBytes(Charset.forName("UTF-8"));
		System.out.println(Arrays.toString(byteArr)); //[65, 66, 67, 68, 69, 71]
	}
	
	public static void main(String[] args) {
		String str = """
						ICE me inhone chamatkar pe chamatkar kiya hai,
						Hume toh ascharya hota hai ki ek insaan, apne jeevan kaal me,
						itna chamatkar kaise kar sakta hai.
						""";
		replaceString(str,"chamatkar","balatkar");
		
		String str1 = "ABCDEG";
		testChar(str1);
		
 	}

}
