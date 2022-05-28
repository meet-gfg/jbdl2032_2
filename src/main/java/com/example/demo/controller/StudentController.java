package com.example.demo.controller;


import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {

    Map<Integer,Student> studentMap=new HashMap<>();
    Logger log= LoggerFactory.getLogger(StudentController.class);

    /**
     * 4 apis:
     * 1. add a student - POST
     * 2. retrieve a student - GET
     * 3.update a student - PUT
     * 4. delete a student. _ DELETE
     * */

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        try {
            int id = studentMap.size() + 1;
            student.setId(id);
            studentMap.put(id, student);
            return student;
        }
        catch (Exception ex) {
            log.error("exception while adding student");
        }
        return null;

    }

    @GetMapping("/all")
    public List<Student> getStudent(){
        return new ArrayList<>(studentMap.values());
    }

    @GetMapping("/id")
    public Student getStudentById(@RequestParam("id") int id){
        if(studentMap.containsKey(id))
            return studentMap.get(id);
        else
            return null;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){

        StudentService service=new StudentService();
        return service.updateStudent(student);
    }

    @DeleteMapping("/delete")
    public boolean deleteStudent(@RequestParam("id") int id ){
        if(id==0 || !studentMap.containsKey(id))
            return false;
        else{
            studentMap.remove(id);
            return true;
        }
    }


}
