package com.example.demofeignclient.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "tutv", url = "http://localhost:8099/" )//, configuration = DemoFeignClientConfig.class)
@FeignClient(name = "tutv", url = "http://localhost:8099/", configuration = DemoFeignClientConfig.class)
public interface WeatherFeignClient {

    @GetMapping("/temperature")
    String greeting( @RequestHeader(name = "tutv1") String header, @RequestParam(name = "city") String city);
}
