package com.example.restservice1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class RestService1Application {

    public static void TestConsumer(List<Integer> students, Consumer<Integer> consumer) {
        for (int i = 0 ; i < students.size() ; i++) {
            consumer.accept(students.get(i));
        }
    }

    public static void main(String[] args) {

//        TestConsumer( Stream.of(1,3,5,6,7,10).collect(Collectors.toList()) ,  (x) -> {
//            System.out.println("Consumer: " + x);
//        } );

        //TestConsumer();
        //return;
        SpringApplication.run(RestService1Application.class, args);
    }

}
