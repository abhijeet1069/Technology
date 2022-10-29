package intro;

import test.Parent;

/**
	JAVA access modifier:
		private:
			If a method or variable is marked as private, then only code inside the same class can access the the variable or call the class.
			private access modifier is not allowed for classes, as no one would be able to call it and render it useless.
		
		default:
			Code can be accessed of same class and same package. I think compiler is resolving via class name. And that is why public class
			name is same as file name.
			
		protected:
			protected provides same access as default access, with addition of subclass can access protected methods and member variables
			even outside other packages
			
		public:
			No restriction of class or package
			
		JAVA access modifier assigned to a JAVA class takes precedence over any access modifiers assigned to fields, constructors and
		methods of that class. If a class is marked with default access, its contents, even itself cannot be accessed outside package.
		
		You cannot reduce the visibility of the inherited method from Parent
 **/

//class Child extends Parent{
//	public void print() {
//		System.out.println("Hello, World"+super.age);
//	}
//}

public class AccessModifier_3 {

	public static void main(String[] args) {
//		Child child = new Child();

	}

}
