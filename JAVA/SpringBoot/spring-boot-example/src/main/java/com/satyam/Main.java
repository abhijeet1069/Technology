package com.satyam;

/**
Apache Tomcat is a free and open source implementation of the Jakarta Servlet, Jakarta Expression Language and WebSocket
 technologies. It provides a pure JAVA HTTP web server environment in which JAVA code can also run. Thus, it's a JAVA
 web application server.
**/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse("Hello, World");
    }
    //record GreetResponse(String greet){ }

    class GreetResponse{
        private final String greet;
        GreetResponse(String greet){
            this.greet = greet;
        }
    }
}
