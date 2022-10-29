package intro;

import intro.Outer.Inner;

/*
	Nested classes are classes that are defined inside another class.Nested class is only to be used from inside its owning class.
	Nested classes provide even more strong grouping than packages
		public class Cache {
    	private Map<String, CacheEntry> cacheMap = new HashMap<String, CacheEntry>();
    	private class CacheEntry { //CacheEntry is hidden from other classes. If it would had been public it would be exposed to other classes.
        	public long   timeInserted = 0;
        	public object value        = null;
    	}
    	public void store(String key, Object value){
        	CacheEntry entry = new CacheEntry();
        	entry.value = value;
        	entry.timeInserted = System.currentTimeMillis();
        	this.cacheMap.put(key, entry);
    	}
	
	The different types of nested classes are:
		1) Static nested classes
			public class Outer {
  				public static class Nested {
  					}
				}
			Outer.Nested instance = new Outer.Nested();
		
		2) Non static nested classes (Inner classes)
			public class Outer {
  				public class Inner {
  					}
				}
			Outer outer = new Outer();
			Outer.Inner inner = outer.new Inner();
			
		3) Local classes - Can be accessed from inside the method or scope block in which they are defined.
			class Outer {
    			public void printText() {
        			class Local {
        		}
        			Local local = new Local();
    			}
				}
				
		4) Anonymous classes - Can implement an interface
				MyInterface instance = new MyInterface() {
    				public void doIt() {
        				System.out.println("Anonymous class doIt()");
    						}
						};

					instance.doIt();
 * */

class Outer{
	public static class Inner{
		static void hello() {
			System.out.println("Hello, World");
		}
	}
}

public class NestedClasses_5 {

	public static void main(String[] args) {
		Outer.Inner obj = new Outer.Inner();
		Inner.hello();

	}

}
