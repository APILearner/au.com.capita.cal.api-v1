##Spring Boot Web Application

See here for more informations: 

### Usage

- Run the application and go on http://localhost:8080/healthCheck to test the service status . Can hit directly from Google Chrome.
- Use the following urls to invoke controllers methods and see the interactions

### Base URL

http://localhost:8080

### Method
-POST 
 http://localhost:8080/calculate
 
### Request Body : Find in Postman collection
json format :
 
 {
"value" : "7+(6*5^2+3-4/2)+23"
  }
 
 Install postman/Import the postman collection request from postManApi_Test folder and hit the request.

### Build and run

#### Configurations

Open the `application.properties` file and set your own configurations for the
database connection if you want to use database.

#### Prerequisites

- Java 8
- Maven 3
- Spring boot
- Mockito

#### To run Application

Run the main class/Application.java

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.
