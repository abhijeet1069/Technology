package commandLine;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {

    public static void commandLine() throws IOException {
        System.out.println(System.getProperty("os.name"));
        String[] command = new String[]{"date"};
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while((line= reader.readLine()) != null)
            System.out.println(line);
    }
    public static void main(String[] args) throws IOException {

        commandLine();
        //System.out.println("Processors: "+Runtime.getRuntime().availableProcessors());
        //System.out.println("Total Memory (MB): "+(Runtime.getRuntime().totalMemory())/(1024*1024));
        //System.out.println("Max Memory (MB): "+(Runtime.getRuntime().maxMemory())/(1024*1024));
    }
}
