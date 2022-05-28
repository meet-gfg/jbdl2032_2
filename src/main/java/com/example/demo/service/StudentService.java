package com.example.demo.service;

import com.example.demo.controller.StudentController;
import com.example.demo.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class StudentService {


    Map<Integer,Student> studentMap=new HashMap<>();
    Logger log= LoggerFactory.getLogger(StudentController.class);
    /***
     *
     *
     * */


    public Student updateStudent(Student student){
        log.info(String.valueOf(student.hashCode()));
        if(student.getId()==0 || !studentMap.containsKey(student.getId()))
            return null;
        else{
            studentMap.put(student.getId(),student);
            return student;
        }
    }
}


















