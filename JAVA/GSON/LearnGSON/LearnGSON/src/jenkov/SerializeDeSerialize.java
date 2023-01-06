package jenkov;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Processor{
	public String brand; //name has to be matched in json else null will placed
	public String name;
	
	public String toString() {
		return brand+" "+name;
	}
}

public class SerializeDeSerialize {

	public static void main(String[] args) {
		
		//Gson gson = new Gson();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		String intelString = "{\"brand\": \"Intel\",\"name\": \"i5 8100H\"}";
		String appleString = "{\"brand\": \"Apple\",\"name\": \"M1 pro\"}";
		
		Processor intelPros = gson.fromJson(intelString, Processor.class);
		Processor applePros = gson.fromJson(appleString, Processor.class);
		
		System.out.println(applePros);
		
	}

}
