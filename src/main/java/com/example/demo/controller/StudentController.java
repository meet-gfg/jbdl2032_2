package com.example.demo.controller;


import com.example.demo.domain.Student;
import com.example.demo.service.StudentDBDemoService;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    Logger log= LoggerFactory.getLogger(StudentController.class);


    @Autowired
    StudentService service;

    @Autowired
    StudentDBDemoService studentDBDemoService;

    @Autowired
    ApplicationContext applicationContext;





   /**
    * @Component : if this annotation is used directly or indirectly. Spring will create Bean of a class.
    * if an object is created,managed and accessed by Spring  such objects are called Beans
    * */

   /**
    * Accessing an object by our service
    * 1. ask from Application Context
    * 2. Inject it.
    *
    * */

    /**
     * 4 apis:
     * 1. add a student - POST
     * 2. retrieve a student - GET
     * 3.update a student - PUT
     * 4. delete a student. _ DELETE
     * */


    /**
     * ResponseEntity is packet that carries with response data and HTTPstatus code.
     *
     * HTTPStatus is enum which maps the http status code with requirement.
     * */


    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student){
        return new ResponseEntity<>(studentDBDemoService.addStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudent(){
        Object s=applicationContext.getBean("getStudent");
        System.out.println(s.hashCode());
        return new ResponseEntity<>(service.getAllStudent(),HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Student> getStudentById(@RequestParam("id") int id) throws SQLException {
        return new ResponseEntity<>(studentDBDemoService.getStudentById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.updateStudent(student),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudent(@RequestParam("id") int id ){

        return new ResponseEntity<>(service.deleteStudent(id),HttpStatus.OK);
    }


}
