package com.example.demofeignclient.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tutv2", url = "http://localhost:8099/" )//, configuration = DemoFeignClientConfig.class)
//@FeignClient(name = "tutv1", url = "http://localhost:8099/", configuration = DemoFeignClientConfig.class)
public interface RestFeignClient {

    @GetMapping("/greet")
    String greeting( @RequestParam String name);
}
