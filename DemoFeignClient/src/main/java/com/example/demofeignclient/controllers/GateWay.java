package com.example.demofeignclient.controllers;

import com.example.demofeignclient.proxy.RestFeignClient;
import com.example.demofeignclient.proxy.WeatherFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GateWay {

    @Autowired
    WeatherFeignClient weatherFeignClient;

    @Autowired
    RestFeignClient restFeignClient;

    @GetMapping("/weather")
    public void getWeather(@RequestParam String city) {

        log.info("Weather is: {}" ,weatherFeignClient.greeting("TestHeader12", city) );

    }

    @GetMapping("/greet")
    public void geeting(@RequestParam String name) {

        restFeignClient.greeting(name);

    }
}
