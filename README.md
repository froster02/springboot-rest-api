springboot-rest-api

A Spring Boot REST API example project in Java. This project demonstrates how to build RESTful endpoints using Spring Boot, with a focus on the use of Java annotations for simplifying configuration and development.

Table of Contents

- Overview
- Project Structure
- Key Annotations Used
- Annotations in This Project
- How to Run
- License

---

Overview

This repository provides a simple REST API using Spring Boot. It showcases different HTTP operations (GET, POST, PUT, DELETE) for a Student resource, and demonstrates how Java annotations are leveraged to build and document APIs efficiently.

---

Project Structure

src/
  main/
    java/
      net/javaguides/springboot/
        SpringbootRestApiApplication.java
        controller/
          HelloWorldController.java
          StudentController.java
  test/
    java/
      net/javaguides/springboot/
        SpringbootRestApiApplicationTests.java

---

Key Annotations Used

Why Use Annotations in Java (Spring Boot)?

Annotations in Java provide metadata that can be processed by the compiler or at runtime. In Spring Boot, annotations are vital for:
- Reducing boilerplate code
- Declaring configuration
- Mapping HTTP routes to methods
- Injecting dependencies
- Defining component roles (like controllers, services, etc.)

Spring Boot annotations make your code more readable, maintainable, and declarative.

Important Annotations in This Project

Below are the key annotations found in your project, with explanations of their purpose and where they are used:

Annotation                              | Purpose                                                                 | Where Used
---------------------------------------- | ----------------------------------------------------------------------- | --------------------------------------------------------------
@SpringBootApplication                   | Marks the main class as a Spring Boot application                       | SpringbootRestApiApplication.java
@RestController                          | Marks a class as a REST controller (combines @Controller + @ResponseBody) | HelloWorldController.java, StudentController.java
@GetMapping, @PostMapping, @PutMapping, @DeleteMapping | Maps HTTP methods (GET, POST, etc.) to specific handler methods         | StudentController.java, HelloWorldController.java
@PathVariable                            | Binds URI template variables to method parameters                       | StudentController.java
@RequestParam                            | Binds HTTP request parameters to method parameters                      | StudentController.java
@RequestBody                             | Maps the body of an HTTP request to a Java object                       | StudentController.java
@ResponseStatus                          | Specifies the HTTP status for the response                              | StudentController.java
@SpringBootTest                          | Indicates a Spring Boot test class                                      | SpringbootRestApiApplicationTests.java
@Test (JUnit)                            | Marks a method as a test method                                         | SpringbootRestApiApplicationTests.java

---

Annotations in This Project (with Examples)

1. Application Entry Point

File: SpringbootRestApiApplication.java

@SpringBootApplication
public class SpringbootRestApiApplication { ... }

- @SpringBootApplication: Enables auto-configuration, component scanning, and configuration support.

---

2. Creating REST Controllers

Files:  
HelloWorldController.java  
StudentController.java

@RestController
public class HelloWorldController { ... }

@GetMapping("/hello-world")
public String helloWorld() { ... }

- @RestController: Declares the class as a RESTful web service controller.
- @GetMapping: Maps HTTP GET requests onto specific handler methods.

---

3. Handling HTTP Operations with Annotations

File: StudentController.java

@GetMapping("students/{id}")
public Student studentPathVariable(@PathVariable("id") int studentId) { ... }

@PostMapping("students/create")
@ResponseStatus(HttpStatus.CREATED)
public Student createStudent(@RequestBody Student student) { ... }

@PutMapping("students/{id}/update")
public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) { ... }

@DeleteMapping("students/{id}/delete")
public String deleteStudent(@PathVariable("id") int studentId) { ... }

- @PathVariable: Extracts values from the URI.
- @RequestBody: Binds the HTTP request body to a method parameter.
- @ResponseStatus: Sets the HTTP status code for a response.
- @PostMapping, @PutMapping, @DeleteMapping: Handle POST, PUT, DELETE requests, respectively.

---

4. Testing with Annotations

File: SpringbootRestApiApplicationTests.java

@SpringBootTest
class SpringbootRestApiApplicationTests {
    @Test
    void contextLoads() { }
}

- @SpringBootTest: Used for integration testing in Spring Boot.
- @Test: JUnit annotation for marking test methods.

---

How to Run

1. Clone the Repository:
   git clone https://github.com/froster02/springboot-rest-api.git
   cd springboot-rest-api

2. Build and Run:
   ./mvnw spring-boot:run
   Or use your IDE’s Spring Boot support.

3. Access Endpoints:
   - GET /hello-world
   - GET /students/{id}
   - POST /students/create
   - ...and others as shown in StudentController.java

---

License

This project currently does not specify a license.

---

Note:  
This summary was generated based on a code search. For more details or to view the full code, visit the GitHub repository: https://github.com/froster02/springboot-rest-api/search?q=%40

If you want a breakdown of a specific annotation or file, just let me know!
