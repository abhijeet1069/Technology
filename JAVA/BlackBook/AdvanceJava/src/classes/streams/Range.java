package classes.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
A stream is not a data-structure, instead it takes input from Collections, Arrays or I/O channels.
Streams don't change the original data structure, they only provide the result as per the pipelined methods.
 * */

public class Range {
	
	//arrays stream
	public static void arrayStream() {
		int[] arr = new int[] {2,3,10,11,13,14,19};
		Arrays.stream(arr).filter(n->(n%2 == 0)).forEach(System.out::println);
	}

	//Collection stream
	public static void setStream() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(12); set.add(14); set.add(23); set.add(25); set.add(38); set.add(77);
		set.stream().filter(n->(n%2 == 0)).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		setStream();
	}
}
