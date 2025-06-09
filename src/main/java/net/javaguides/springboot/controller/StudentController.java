package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //1. http://localhost:8080/student
    @GetMapping("student")
    public Student getSTudent() {
        return new Student(1, "John", "Doe");
    }

    //2. http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Jane", "Diablo"));
        students.add(new Student(3, "Jim", "Beam"));
        students.add(new Student(4, "Jack", "Daniels"));
        return students;
    }

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
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }
}

