package com.example.restfulapiapplicationdeploy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Cake{
    @GetMapping("birthdaySora")
    public String cake(){
        return "cake";
    }
}
