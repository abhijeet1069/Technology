package tutorialsPoint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Student{
	private String name;
	private int age;
	private String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String toString() {
		return "Student [name: "+name+", age: "+age+"]";
	}
	
	
}

public class GsonTester {
	public static void main(String[] args) {
		String jsonString = "{\"name\":\"Mukesh\", \"age\":\"21\"}";
		
		//Create a Gson object
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting(); //for printing with proper indentation
		Gson gson = builder.create();
		
		//Serialize(String to object) JSON to Object
		Student student = gson.fromJson(jsonString, Student.class);
		System.out.println(student);
		
		//Deserialization (String to object)
		jsonString = gson.toJson(student);
		System.out.println(jsonString);
	}

}
