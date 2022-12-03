package com.satyam.app;

/** 
Generate simple JAVA webapp:
    mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

Package project into a JAR (not runnable jar)
    mvn package

Testing packaged JAR:
    java -cp my-app-1.0-SNAPSHOT.jar com.satyam.app.App

Cleaning compiled JAR
    mvn clean

Maven Wrapper - Works even if maven is not installed. Used by intellij too.
    mvn wrapper:wrapper
*/
public class App {
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }
}
