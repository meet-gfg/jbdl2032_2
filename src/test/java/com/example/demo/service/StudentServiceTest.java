package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class StudentServiceTest {


    @Autowired
    StudentService service;


    /**
     * public class Thesis {
     *
     *     private IValidator validtator;
     *
     *     public TextEditor(Ivalidator validtator) {
     *         this.validtator = validtator;
     *     }
     * }
     * */

    @Test
    public void testStudentService() {
        //StudentService service = new StudentService(new StudentInternalServiceImpl());
        //StudentService service = new StudentService(new StudentInternalServiceImplDev());
       // Assertions.assertEquals(10, service.getStudentInteger());
    }
}