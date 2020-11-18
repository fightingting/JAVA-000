package com.example.starter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class School {
    
    @Autowired(required = true)
    Klass class1;
    
    @Autowired
    Student student100;
    
    public void ding(){
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }
    
}
