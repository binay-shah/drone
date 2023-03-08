## Spring Boot Musala Soft Drone Project
-----
This is a sample Java / Maven / Spring Boot (version 2.7.9) application

## How to Run
-----
This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.
-Make sure you are using JDK 1.8 and Maven 3.x
-You can build the project and run the tests by running mvn clean package
- Once successfully built, you can run the service by one of these two methods:

`mvn clean package
java -jar  target/assignment-0.0.1-SNAPSHOT.jar
 mvn spring-boot:run`

## About the Service

The service via REST API allows clients to communicate with the drones. 
It uses an in-memory database (H2) to store the data. 
you can call some REST endpoints  on port 8080. (see below)

Here are some endpoints you can call:

`http://localhost:8080/drones
http://localhost:8080/drones/loading
http://localhost:8080/drones/{droneId}/battery_level
http://localhost:8080/drones/{droneId}/medications
http://localhost:8080/drones/{droneId}/medication`
