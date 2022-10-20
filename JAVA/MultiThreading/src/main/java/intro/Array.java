package intro;

/*
JRE (Java Runtime Environment) contains enough to execute a Java application but not to compile it.

Java SDK contains JRE, Java compiler and set of other tools.

Java has evolved into 3 different sets of API or profiles:
	1) JSE - Java Standard  Edition for desktop and standalone server applications.

	2) JEE - Java Enterprise Edition for developing and executing Java components that run embedded in a Java server. For ex:
		a. Servlets
		b. Java Server Pages (JSP)
		c. Java Server Faces (JSF)
		d. Enterprise Java Beans (EJB)
		e. Two phase commit transactions
		f. Java Message Service message queue API (JMS)

	3) JME - Java Micro Edition for developing and executing Java applications on mobile phones and embedded devices.
		a. Java Applets - Deprecated
		b. JavaFX - Started as an alternate to applets but has far more capabilities


Note:
	java command starts up the JVM.

	From JAVA 10, compiler can infer the type of variable from value assigned to it.
		var str = "hello";



In MacOS Montery 12.6
	Setting up JAVA HOME
		nano ~/.zshrc
		export JAVA_HOME=$(/usr/libexec/java_home)  //Points java home to recent version of JDK

jwebserver - simple web server in JAVA 18.0

* */

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        var str = "Hello" ; //new feature in JAVA. It can automatically detect variable type.
        System.out.println(str+12);

        int[] arr = new int[]{12,3,4,4,3,4,24};
        System.out.println(Arrays.toString(arr)); //Good way to avoid messy for loop to print array
    }
}
