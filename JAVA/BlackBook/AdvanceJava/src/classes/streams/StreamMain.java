package classes.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
A stream is not a data-structure, instead it takes input from Collections, Arrays or I/O channels.
Streams don't change the original data structure, they only provide the result as per the pipelined methods.

Lambda expressions are similar to methods but they do not need a name and can be implemented right in the body of a method.
 * */

public class StreamMain {
	
	//arrays stream
	public static void arrayStream() {
		int[] arr = {2,3,10,11,13,14,19};
		Arrays.stream(arr).filter(n->(n%2 == 0)).forEach(System.out::println);
	}
	
	//Collection Stream
	public static void setStream() {
		Set<Integer> set = new HashSet<Integer>();
		set.add(12); set.add(14); set.add(23); set.add(25); set.add(38); set.add(77);
		set.stream().filter(n->(n%2 == 0)).forEach(System.out::println);
	}
	
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
