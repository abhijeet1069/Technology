package intro;

/*
	Java Enums - A mechanism for defining constants.
	Before JAVA enums we used to use:
	public class Constants{
		public static final int HIGH = 1;
		public static final int MEDIUM = 2;
		public static final int LOW = 3;
		public static final String FILE = "FILE";
	}
		
 * */

 enum Level{
	HIGH(1),
	MEDIUM(2),
	LOW(3);
	
	private int intValue;
	
	private Level(int intVal) {
		this.intValue = intVal;
	}
}

public class Enum_9 {

	public static void main(String[] args) {
		Level level = Level.HIGH;
		level = Level.LOW;
		Level[] values = Level.values(); 
		
		for(Level temp : values)
			System.out.println(temp.toString());
	}

}
