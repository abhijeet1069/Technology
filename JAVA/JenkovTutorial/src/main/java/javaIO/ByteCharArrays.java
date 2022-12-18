package javaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 Byte and char arrays are often used to temporarily store data internally in applications.
 File can loaded into an array, and data can be accessed via indexing.
 * */

public class ByteCharArrays {

    public static void readArrays() throws IOException{
        File file = new File("input.txt");
        InputStream input = new FileInputStream(file);
        byte[] arr = new byte[(int)file.length()];
        //Reading arrays via InputStream reader
        input.read(arr);
        for(int i = 0; i < 10 ;i++)
            System.out.print((char)arr[i]);
        input.close();
    }

    public static void main(String[] args) throws IOException {
        readArrays();
    }
}
