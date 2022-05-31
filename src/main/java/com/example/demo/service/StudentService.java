package com.example.demo.service;

import com.example.demo.controller.StudentController;
import com.example.demo.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @Service annotation is used for marking the service class and Spring will generate the bean of it
 * because it indirectly annotates with @Component
 *
 * */

@Service
public class StudentService {

    Map<Integer,Student> studentMap=new HashMap<>();
    Logger log= LoggerFactory.getLogger(StudentController.class);

    public Student updateStudent(Student student){
        if(student.getId()==0 || !studentMap.containsKey(student.getId()))
            return null;
        else{
            studentMap.put(student.getId(),student);
            return student;
        }
    }

    public Student addStudent(Student student) {
        try {
            int id = studentMap.size() + 1;
            student.setId(id);
            studentMap.putIfAbsent(id, student);
            return student;
        }
        catch (Exception ex) {
            log.error("exception while adding student");
        }
        return null;
    }

    public List<Student> getAllStudent() {

        return new ArrayList<>(studentMap.values());
    }

    public Student getStudentById(int id) {

        if(studentMap.containsKey(id))
            return studentMap.get(id);
        else
            return null;
    }

    public boolean deleteStudent(int id) {

        if(id==0 || !studentMap.containsKey(id))
            return false;
        else{
            studentMap.remove(id);
            return true;
        }
    }


    /**
     * usage of @Bean : it can be used on method only.
     * */
    @Bean("mainBean")
    public Student createStudent(){
        return new Student(0,"superman",100,"abc@gmail.com");
    }
}


















