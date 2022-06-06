package com.example.demo.service;

import com.example.demo.appinterface.StudentInternalService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("mainImpl")
@Primary
public class StudentInternalServiceImpl implements StudentInternalService {



    /** this method has a code to interact with the production service*/
    @Override
    public int getStudentInteger() {
        return 10;
    }
}
