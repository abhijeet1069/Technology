package classes.innerClass;

/*
Inner class has full access to the member variables of its outer class.
The object of inner class can only be created in the context of its outer class. Inner classes are used to
implement security features when you are writing some important code, such as password checking in an application.
 * */

public class OuterClass {

	int[] a = {2,4,5,7,10};
	
	class InnerClass{
		public void odd_even() {
			for(int i = 0; i < a.length; i++) {
				if(a[i]%2 == 0) {
					System.out.println("The value at the position "+a[i]+" is even");
				}
				else {
					System.out.println("The value at the position "+a[i]+" is odd");
				}
			}
		}
	}
	
	public void call_inner() {
		InnerClass val = new InnerClass();
		val.odd_even();
	}
	
	public static void main(String[] args) {
		OuterClass show = new OuterClass();
		show.call_inner();
	}
}
