package com.example.restfulapiapplicationdeploy.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    public UserController(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    // GET /users/1 or /users/10 -> 10이란 id값도 서버측에서 문자열로 처리되어 전달됨
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){ // 위에서 보면 문자열로 처리되므로 int id로 해도되는 것
        return service.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        User savedUser = service.save(user);
    }
}
