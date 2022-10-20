package intro;

/*
   In Java Strings are immutable.
   Note : The fastest way of concatenating strings is to create StringBuilder once and reuse same instance
   inside the loop.
* */

public class Strings {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello"; //String literal is created in String pool. Points to same string object
        String str3 = new String("Hello"); //A different object is created everytime. No compiler optimization.

        String puzzle = """
                        Love sees not with the eyes but with the mind,
                        and therefore is a winged cupid painted blind.
                        """;        //new Java 13 feature for multi-line string

        System.out.println((str1==str2)+" , "+(str1==str3)); //OP - true, false
        System.out.println(puzzle+" William Shakespeare");
    }
}
