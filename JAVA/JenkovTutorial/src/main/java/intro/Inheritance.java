package intro;

/*
	Inheritance is a method of code reuse:
		When a subclass extends a superclass in JAVA, all protected and public fields and methods are inherited by the subclass.
		Superclass -> Subclass
		Parent -> Child
		Generalization -> Specialization
		Cisco -> Wipro
		
		JAVA inheritance mechanism does not include constructors. However, subclasses can still call them using super()
 * */

class Parent{
	void show() {
		System.out.println("I am the parent");
	}
}

class Child extends Parent{
	void show() {
		System.out.println("I am the child");
	}
}

public class Inheritance {

	public static void main(Strings[] args) {
		/*
		 Left		Right		Output
		 Parent		Parent		I am the parent
		 Parent		Child		I am the child
		 Child		Parent		java.lang.ClassCastException in runtime
		 Child		Child		I am the child
		  */
		
		Parent child = (Child) new Parent(); //Downcasting - Will result in error    
		child.show();

	}

}
