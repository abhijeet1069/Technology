package classes.streams;

import java.util.stream.IntStream;

/**
Stream API heavily uses Lambda functions.

Lambda expressions are similar to methods but they do not need a name and can be implemented right in the 
body of a method.
 * */

public class Lambda {
	public static void main(String[] args) {
		IntStream numbers = IntStream.range(10, 30); //similar to python 10-29
		
		numbers.map(n->n*n)
		.forEach(System.out::println);
	}
}
