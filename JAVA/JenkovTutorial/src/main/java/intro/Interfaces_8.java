package intro;

/*
Java interface can only contain method signatures and fields (which are static and final(cannot be assigned)). A Java interface is not intended to contain implementations 
of the methods, only the signature (name, parameters and exceptions) of the method.

JAVA interfaces are a way to achieve polymorphism.

public interface URLProcessor { //skeleton

    public void process(URL url) throws IOException;
}

public abstract class URLProcessorBase implements URLProcessor { //skeleton and muscles

    public void process(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();

        try{
            processURLData(input);
        } finally {
            input.close();
        }
    }

    protected abstract void processURLData(InputStream input) //this function has to be implemented
        throws IOException;

}

public class URLProcessorImpl extends URLProcessorBase { //Final skin

    @Override
    protected void processURLData(InputStream input) throws IOException {
        int data = input.read();
        while(data != -1){
            System.out.println((char) data);
            data = input.read();
        }
    }
}


 * */

interface Sample{
	int num = 10;
	public void hello();
}

public class Interfaces_8 implements Sample{

	public void hello() {
		//Sample.num = this.num+1;
		System.out.println("Hello, World "+Sample.num);
		
	}
	
	public static void main(String[] args) {
		Interfaces_8 obj = new Interfaces_8();
		obj.hello();
	}

}
