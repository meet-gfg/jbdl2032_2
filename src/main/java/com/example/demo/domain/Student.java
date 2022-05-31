package com.example.demo.domain;


import lombok.*;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class Student{

    private int id;
    private String name;
    @Min(value=6,message = "age should greater than 6")
    @Max(value=40,message = "age should less than 40")
    private int age;

    @Email(message = "invalid email")
    private String email;


}
