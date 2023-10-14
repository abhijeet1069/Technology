package gson.gettingStarted;

public class UserSimple {
	private String name;
	private String email;
	private int age;
	private boolean isDeveloper;
	
	public UserSimple(String name, String email, int age, boolean isDeveloper) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.isDeveloper = isDeveloper;
	}

	@Override
	public String toString() {
		return "UserSimple [name=" + name + ", email=" + email + ", age=" + age + ", isDeveloper=" + isDeveloper + "]";
	}	
}
