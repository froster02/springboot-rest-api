package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

@RestController


//@RequestMapping("students")
// This annotation maps HTTP requests to handler methods of MVC and REST controllers
// It can be used at the class level to define a base URI for all methods in the controller

public class StudentController {

    //1. http://localhost:8080/student
//    @GetMapping("student")
//    public Student getSTudent() {
//        return new Student(1, "John", "Doe");
//    }

    //2. http://localhost:8080/students
//    @GetMapping("students")
//    public List<Student> getStudents() {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1, "John", "Doe"));
//        students.add(new Student(2, "Jane", "Diablo"));
//        students.add(new Student(3, "Jim", "Beam"));
//        students.add(new Student(4, "Jack", "Daniels"));
//        return students;
//    }

    //3. Springboot RESTApi with path variable
    // {id} - URI template variable
    // http://localhost:8080/students/1
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId) {
        return new Student(studentId, "John", "Doe");
    }

    //4. Springboot RESTApi with multiple path variable
    // {id}/{firstName}/{lastName} - URI template variable
    // http://localhost:8080/students/1/john/doe
    @GetMapping("students/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    //5. Springboot RESTApi with request parameter
    // http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id) {
        return new Student(id, "John", "Doe");
    }

    //6. Springboot RESTApi with multiple request parameter
    // http://localhost:8080/students/query?id=1&firstName=Arush&lastName=Naudiyal
//    @GetMapping("students/query")
//    public Student studentRequestVariable(@RequestParam int id,
//                                          @RequestParam String firstName,
//                                          @RequestParam String lastName) {
//        return new Student(id, firstName, lastName);
//    }


//    @PostMapping: A Spring Boot annotation for handling HTTP POST requests.
//    @ResponseStatus: Specifies the HTTP status code for the response.
//    @RequestBody: Maps the request body to a Java object.
//    Student: A custom Java class representing a student entity (likely defined in net.javaguides.springboot.bean.Student).
//    out.println: A method from java.lang.System to print to the console.
//    JSON Payload: The data sent in the body of the HTTP POST request, typically in JSON format.

    //7. Springboot RESTApi that handles HTTP POST request - creating new resource
    // @PostMapping & @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        out.println(student.getId());
        out.println(student.getFirstName());
        out.println(student.getLastName());

        return student;
    }

    //8. Springboot RESTApi that handles HTTP PUT request
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        out.println(student.getFirstName());
        out.println(student.getLastName());

        return student;
    }

    //9. Springboot RESTApi that handles HTTP DELETE request
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        out.println(studentId);
        return "Student deleted successfully";
    }

    //10. http://localhost:8080/student
    // This endpoint returns a ResponseEntity with a Student object and HTTP status OK
//    @GetMapping("student")
//    public ResponseEntity<Student> getSTudent(){
//        Student student = new Student(1, "John", "Doe");
//        // Return a ResponseEntity with the student object and HTTP status OK
//        //return new ResponseEntity<>(student, HttpStatus.OK);
//        // Alternatively, you can use ResponseEntity.ok() for a more concise syntax
//        return ResponseEntity.ok(student);
//    }

    //11. http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "john", "Doe");
        // Return a ResponseEntity with custom header and HTTP status OK
        return ResponseEntity.ok()
                .header("custom-header", "froster02")
                .body(student);
    }

}

