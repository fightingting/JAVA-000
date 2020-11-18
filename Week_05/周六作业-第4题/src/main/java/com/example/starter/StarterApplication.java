package com.example.starter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Arrays;

@EnableConfigurationProperties(MyStarterProperties.class)
@Configuration
@ComponentScan
public class StarterApplication {

    @Resource
    MyStarterProperties properties;


    @Bean
    public Student getStudent(){
        Student student = new Student();
        student.setId(properties.getStudentId());
        student.setName(properties.getStudentName());
        return student;
    }

    @Bean
    public Klass getKlass(){
        Klass klass = new Klass();
        klass.setStudents(Arrays.asList(getStudent()));
        return klass;
    }

    @Bean
    public School getSchool(){
        School school = new School();
        school.setClass1(getKlass());
        school.setStudent100(school.getClass1().students.get(0));
        return school;
    }

}
