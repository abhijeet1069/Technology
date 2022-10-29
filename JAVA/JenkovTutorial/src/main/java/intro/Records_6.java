package intro;

/*
 	JAVA Records - Introduced in JAVA 14
 	Avoids POJO boiler template of getter, constructor, toString() methods. But no setter methods since records are immutable.
 	Subclasses of records can't be created.
 * */

record Vehicle(String brand, String licensePlate) {
	//we can create our own constructors, methods, static methods also
}

public class Records_6 {
	public static void main(String[] args) {
		String brand = "Mercedes";
		String licensePlate = "UX 1238 A95";
		
		Vehicle vehicle = new Vehicle(brand, licensePlate);
		System.out.println(vehicle.brand());
		System.out.println(vehicle.toString());

	}

}
