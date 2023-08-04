package com.example.restservice1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class HelloWorld {

    @GetMapping("/greet")
    public String greeting( @RequestParam(name = "name") String inputName)
    {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        System.out.println("TUTV: " + requestAttributes.getRequest().getHeaderNames().toString() );

        return "Hello : " + inputName;
    }
    @GetMapping("/greeting")
    public String greeting( )
    {
        return "Hello world";
    }
}
