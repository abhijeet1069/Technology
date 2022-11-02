package lambda;

import java.util.Comparator;

/*
Java lambda expressions were introduced in JAVA 8.
A lambda expression is this a function which can be created without belonging to any class.
A Java lambda expression can be passed around as if it was an object and executed on demand.
* */
interface MyFunction{
    public void apply();
}

public class LambdaExpression {
    public static void main(String[] args) {
        //Anonymous implementation of functional interface before Java Lambda expression.
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(stringComparator.compare("hello","world"));

        /*Implementing functional interface (Interface with only 1 abstract method) after lambda expression
        (o1,o2) - Here the compiler is resolving that abstract method compare(T,T) has to be implemented.
        Also, input parameter braces can be avoided for single parameters*/
        Comparator<String> stringComparatorLambda = (o1, o2) -> {return o1.compareTo(o2);};
        System.out.println(stringComparatorLambda.compare("hello","world"));

        MyFunction myFunction = ()->{System.out.println("Hello, World"); };
        myFunction.apply();
    }
}
