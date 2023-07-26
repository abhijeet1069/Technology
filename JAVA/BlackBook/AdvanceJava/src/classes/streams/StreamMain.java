package classes.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
Java streams represent a pipeline through which data will flow and the functions to operate on the data.
A pipeline in this instance consists of a stream source, followed by zero or more intermediate operations,
and a terminal operation.
 * */

public class StreamMain {
	
	// Intermediate operations
	
	// 1) filter(predicate) : filters element on a given predicate
	public static void filterEven() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> evenNumbers = numbers.stream()
											.filter(n->(n%2 == 0))
											.collect(Collectors.toList());
		System.out.println(evenNumbers);
	}
	
	// 2) map(function) : transforms element using a given function
	public static void stringsLength() {
		List<String> strings = Arrays.asList("Java","Streams","Tutorial");
		List<Integer> lengths = strings.stream()
								.map(String::length)
								.collect(Collectors.toList());
		System.out.println(lengths);
	}
	
	// 3) distinct() : returns stream with unique elements
	public static void removeDuplicates() {
		List<Integer> numbersWithDuplicates = Arrays.asList(1,2,2,3,3,3);
		List<Integer> distinctNumbers = numbersWithDuplicates.stream()
										.distinct()
										.collect(Collectors.toList());
		System.out.println(distinctNumbers);
	}
	
	// 4) sorted(comparator) : Sorts elements based on a given comparator
	public static void sortStrings() {
		List<String> unsortedStrings = Arrays.asList("banana","apple","cherry","avocado");
		List<String> sortedStrings = unsortedStrings.stream()
									 .sorted()
									 .collect(Collectors.toList());
		System.out.println(sortedStrings);
	}
	
	// 5) peek(consumer) : Perform an action on each element without modifying the stream
	public static void printOriginalAndDoubled() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		List<Integer> doubledNumbers = numbers.stream()
									   .peek(n->System.out.println("Original: "+n))
									   .map(n->n*2)
									   .peek(n->System.out.println("Original: "+n))
									   .collect(Collectors.toList());
		System.out.println(doubledNumbers);
	}
	
	// Terminal operations
	
	// 1) forEach() : performs an action on each element
	public static void printStrings() {
		List<String> names = Arrays.asList("Alice","Bob","Charlie");
		names.stream().forEach(System.out::println);
	}
	
	// 2) reduce(binaryOperator) - repeated process of combining all elements
	public static void maxString() {
        List<String> words = Arrays.asList("GFG", "Geeks", "for","GeeksQuiz", "GeeksforGeeks");
        Optional<String> longestString = words.stream()
                                   .reduce((word1, word2)
                                    -> word1.length() > word2.length() ? word1 : word2);
        longestString.ifPresent(System.out::println);
	}
	
	
	public static void main(String[] args) {
		maxString();
	}
}
