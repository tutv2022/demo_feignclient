package com.example.restservice1.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Enumeration;
import java.util.stream.Collectors;

@RestController
public class WeatherController {

    @GetMapping("/temperature")
    public String greeting( @RequestParam(name = "city") String city)
    {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        Enumeration<String> headers = requestAttributes.getRequest().getHeaderNames();

        while (headers.hasMoreElements())
            System.out.println("TUTV: " + headers.nextElement()  );

        System.out.println("TestHeader: " + requestAttributes.getRequest().getHeader("tutv1"));
        System.out.println("TestHeader: " + requestAttributes.getRequest().getHeader("header_1"));
        return "City : " + city;
    }


    @GetMapping("/testbody")
    public void greeting2(RequestEntity<String> testBody)
    {
        HttpHeaders headers = testBody.getHeaders();

        headers.forEach( ( k,v ) -> System.out.println("TuTV: " + k + " - Value: " +
                v.stream().collect(Collectors.joining("|"))  ) );

        String bodyTxt = testBody.getBody();

        System.out.println(bodyTxt);
    }

    @PostMapping("/testbody2")
    public void greeting3(RequestEntity<String> testBody)
    {
        HttpHeaders headers = testBody.getHeaders();

        headers.forEach( ( k,v ) -> System.out.println("TuTV: " + k + " - Value: " +
                v.stream().collect(Collectors.joining("|"))  ) );

        String bodyTxt = testBody.getBody();

        System.out.println(bodyTxt);
    }

    @PostMapping("/testbody3")
    public ResponseEntity<String> greeting3(@RequestParam String userName)
    {

        return ResponseEntity.status(HttpStatus.OK).body("It's successfully");
    }

}
