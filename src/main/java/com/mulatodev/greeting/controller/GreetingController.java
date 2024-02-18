package com.mulatodev.greeting.controller;

import com.mulatodev.greeting.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import xyz.mulatodev.greeting.utils.WeatherExternalRestfulService;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Welcome, %s!";
    private final AtomicLong counter = new AtomicLong();

    //private String weather = "";
    //private final String response = "";

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "mulato") String name){

        //WeatherExternalRestfulService accu = new WeatherExternalRestfulService();
        //weather = accu.GetLocationCodeByCityName("Bogotá");

        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
