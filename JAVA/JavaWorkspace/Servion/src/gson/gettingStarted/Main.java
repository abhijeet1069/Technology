package gson.gettingStarted;

import com.google.gson.Gson;

// GSON and JACKSON are quite comparable
public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to GSON 01 - Getting Started");
		
		serializeUserSimple();
	}
	
	//Serialize - object to JSON
	private static void serializeUserSimple() {
		UserSimple user = new UserSimple("Norman","norman@futurestud.io",27,true);
		Gson gson = new Gson();
		String json = gson.toJson(user);
		System.out.println(json);
	}
	
	//De-Serialize
	private static void derializeUserSimple() {
		String jsonString = "{'name':'Norman','email':'norman@futurestud.io','age':27,'isDeveloper':true}";
		Gson gson = new Gson();
		UserSimple userSimple = gson.fromJson(jsonString, UserSimple.class);
		System.out.println(userSimple.toString());
	}
}
