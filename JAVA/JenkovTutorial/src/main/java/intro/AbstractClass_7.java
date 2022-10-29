package intro;

/*
 * 	Basically, it is factoring out the common. Cisco->Wipro
	JAVA abstract class is a class which cannot be instantiated. The purpose of abstract classes is to function as base classes
	which can be extended by subclasses to create full implementation.
	
	public abstract class URLProcessorBase {
    
    public void process(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();

        try{
            processURLData(input);
        } finally {
            input.close();
        }
    }

    protected abstract void processURLData(InputStream input) //How is the URL processed will depend on child class
        throws IOException;

}

public class URLProcessorImpl extends URLProcessorBase { //Example of Template Method design pattern

    @Override
    protected void processURLData(InputStream input) throws IOException {
        int data = input.read();
        while(data != -1){
            System.out.println((char) data);
            data = input.read();
        }
    }
}

main(){
	URLProcessorImpl urlProcessor = new URLProcessorImpl();
	urlProcessor.process(new URL("http://jenkov.com"));

}
 * */

public class AbstractClass_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
