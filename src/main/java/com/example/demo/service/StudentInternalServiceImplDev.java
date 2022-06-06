package com.example.demo.service;

import com.example.demo.appinterface.StudentInternalService;
import org.springframework.stereotype.Service;

@Service("devImpl")
public class StudentInternalServiceImplDev implements StudentInternalService {


   /** this method has code to get the data from my local machine*/
    @Override
    public int getStudentInteger() {
        return 0;
    }
}
