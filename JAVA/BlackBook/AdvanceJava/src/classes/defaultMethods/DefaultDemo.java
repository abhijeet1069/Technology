package classes.defaultMethods;

/*
Default methods - It is available to all implementation classes of that interface. These classes can 
override the implementation of the default method and provide a different implementation. Introduced in JAVA 8
for backward compatibility.

Access Specifiers:
	public -  Public methods, classes, and fields accessible to all the other classes, methods or packages.
	
	protected - Protected variable or method is accessed only by the members of the same class, subclasses
				related to that class, or within classes of the same package.
				
	default - Available to classes and methods provided in the same package.
	
	private - Can be accessed within the same class in which they are declared.
 * */

interface FuncInterface{
	void add(int num1, int num2);
	
	 default void div(int num1, int num2) {
		int division = num1/num2;
		System.out.println("Result of Division : "+division);
	}
}

class ImplClass implements FuncInterface{

	@Override
	public void add(int num1, int num2) {
		int sum = num1+num2;
		System.out.println("Result of addition: "+sum);
	}
	
	public void div(int num1, int num2) {
		float division = (float)num1/num2;
		System.out.println("Result of Division : "+division);
	}
}

public class DefaultDemo {

	public static void main(String[] args) {
		FuncInterface fi = new ImplClass();
		fi.add(2,3);
		fi.div(23, 2);
	}
}
