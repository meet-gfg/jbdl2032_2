package com.example.demo;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentInternalServiceImpl;
import com.example.demo.service.StudentInternalServiceImplDev;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is the main annotation to start the Spring processing
 **/
@SpringBootApplication
public class FirstSpringProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {


       SpringApplication.run(FirstSpringProjectApplication.class, args);
    }

    @Value("${student.counter}")
    int count=10;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(count);


    }

//    @Bean
//    public Connection getMySqlConnection() throws SQLException {
//       return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb");
//    }
}


