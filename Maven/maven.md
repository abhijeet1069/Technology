# Maven
    Maven is a project management tool for JVM languages.
    Major Tasks:
        a) Building source code
        b) Testing
        c) Packaging into JAR, WAR or EAR
        d) Generate JAVA Docs
        e) Manage dependencies

# Create a Maven quickstart project
    mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4

# Sample POM file
 <project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion> //version of POM model
    <groupId>com.jenkov</groupId>  //unique ID for an organization or a project
    <artifactId>java-web-crawler</artifactId> //name of project
    <version>1.0.0</version> //version number of project
</project>   

# Output
    MAVEN_REPO/com/jenkov/java-web-crawler/1.0.0/java-web-crawler-1.0.0.jar

# clean build file
    mvn clean

# build
    mvn package

# POM (Project Object Model):
    A POM file is an XML representation of project resources like source code, test code, dependencies(external JAR). 
        a) Build life cycles, phases and goals : The build process in Maven is split up into build life
            cycles, phases and goals.
        b) Dependencies and Repositories : If the dependecies are not found in the local Maven repository.
            Maven downloads them from a central Maven repository and puts them in your local repository.
        c) Build Plugins : Build plugins are used to insert extra goals into a build phase. If you need 
            to perform a set of actions for your project which are not covered by the standard Maven build phases and goals, you can add a plugin to the POM file.
        d)  Build Profiles : Build profiles are used if you need to build your project in different ways.

# POM files 
    Super POM - All Maven project POMs extend the Super POM. (In maven installation directory)
    Simple POM - Defines a groupId (organisation: com.satyam), artifactId (project's name) and version (pom.xml in project folder)
    Effective POM - (mvn help:effective-pom)

# Maven dependencies
    a) Snapshot dependency
        Snapshot means that the software is under development, or unstable.
    b) Release dependency
        Release is software that is developed and ready for release or stable.
        
# Dependency Scope <scope></scope>:
    a) Compile - Dependecies marked with compile are available only at compile time inside classpath.
    b)  Provided - Provided by JDK or runtime, available at compile time but not at runtime. 
            (For ex : Inbuilt server)
    c) Runtime - Available at runtime but not compile time (For ex: JDBC connector)
    d) Test - Available while running and writing tests (For ex : JUnit)
    e) System - We provide system path where Maven should find its JAR
            <scope>system</scope>
            <systemPath>~/User</systemPath>

# Repositories:
    a) Local Repository (cached)
        <user-home>/.m2

    b) Remote Repository
        https://mvnrepository.com/
    
    c) Custom remote repository
        <repositories>
            <repository>
                <id>my-internal-site</id>
                <url>http://myservver/repo</url>
            </repository>
        </repositories>

# Build Lifecycle
    a) default
        a) validate : verifies pom.xml
        b) compile : compiles the source code
        c) test : runs the unit tests inside the project
        d) package : packages the source code into an artifact
        e) integration-test : executes the integration tests
        f) verify : verifies the results of integration tests
        g) install : installs the created package into our local repository
        h) deploy : deploys created package to the remote repository

    b) clean
    c) site
