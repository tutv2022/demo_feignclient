package com.example.demofeignclient.Pojo;

import com.example.demofeignclient.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;


public class Student {

    @Autowired
    SampleService sampleService;

    public void display() {
        sampleService.display();
    }
}
