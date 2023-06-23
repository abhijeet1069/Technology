package staticBlock;

/**
In JAVA the static keyword is used to declare members(variables,methods and nested classes) that belong
to the class itself rather than to instances(objects) of the class.

In static methods, this. does not apply
 * */

class Hello{
	public static void staticMessage() {
		//Here we cannot call this. (object methods) 
		System.out.println("Hello, static world!!");
	}
	
	public void message() {
		System.out.println("Hello,World");
	}
}

public class TestStatic {

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.message();
		hello.staticMessage();
	}

}
