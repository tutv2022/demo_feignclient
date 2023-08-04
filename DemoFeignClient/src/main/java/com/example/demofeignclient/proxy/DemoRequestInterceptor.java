package com.example.demofeignclient.proxy;

import com.example.demofeignclient.service.SampleService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;

@Slf4j
//@Component
public class DemoRequestInterceptor implements RequestInterceptor {

    @Autowired
    SampleService sampleService;

    public DemoRequestInterceptor() {
        log.info("DemoRequestInterceptor: Constructor is called ...");
    }
    @Override
    public void apply(RequestTemplate requestTemplate) {
        sampleService.display();



        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest resquest =  requestAttributes.getRequest();
        requestTemplate.request().headers().forEach( (first, second ) -> System.out.printf("TUTV MAP: " + first +
                " Value: " +  second.toString() + "\n") );

        log.info("TUTV === HEADER: ", requestAttributes.getRequest().getHeader("tutv1"));
        requestTemplate.header("header_1", "TuTVaaaa");
    }
}
