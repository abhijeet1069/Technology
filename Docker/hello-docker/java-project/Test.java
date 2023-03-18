public class Test{

    public static void printSystemProperties(){
        System.out.println("Current system properties:");
        System.out.println(System.getProperty("os.name"));
    }
    public static void main(String[] args){
        System.out.println("Hello,World!!");
        printSystemProperties();
    }
}