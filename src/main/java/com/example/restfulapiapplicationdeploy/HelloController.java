package com.example.restfulapiapplicationdeploy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "hello-world";
    }
}
