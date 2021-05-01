package com.example.restfulapiapplicationdeploy.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin") // 공통 접두사
public class AdminUserController {
    private UserDaoService service;

    public AdminUserController(UserDaoService service){
        this.service = service;
    }

    // Read
    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers(){
        List<User> users = service.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","password"); // 포함시킬 데이터
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);
        return mapping;
    }

    // GET admin/v1/users/1 or admin/v1/users/10 -> 10이란 id값도 서버측에서 문자열로 처리되어 전달됨
    @GetMapping("/v1/users/{id}")
    //@GetMapping(value="/users/{id}/",params="version=1") // admin/users/1?version=1
    //@GetMapping(value="/users/{id}",headers="X-API-VERSION=1") // 헤더에 입력
    //@GetMapping("/v1/users/{id}",produces="application/vnd.company.appv1+json") // mime. 헤더에 입력. key=Accept. value에 produces 값넣는다
    public MappingJacksonValue retrieveUserV1(@PathVariable int id){ // 위에서 보면 문자열로 처리되므로 int id로 해도되는 것
        User user = service.findOne(id);
        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }

        //필터링
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate"); // 포함시킬 데이터
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/v2/users/{id}")
    //@GetMapping(value="/users/{id}/",params="version=2") // admin/users/1?version=2
    //@GetMapping(value="/users/{id}",headers="X-API-VERSION=2")
    //@GetMapping("/v1/users/{id}",produces="application/vnd.company.appv2+json") // mime
    public MappingJacksonValue retrieveUserV2(@PathVariable int id){ // 위에서 보면 문자열로 처리되므로 int id로 해도되는 것
        User user = service.findOne(id);
        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }

        // User -> User2
        UserV2 userV2 = new UserV2();
        BeanUtils.copyProperties(user,userV2); // id,name,joinDate,password,ssn
        userV2.setGrade("VIP");

        //필터링
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","grade"); // 포함시킬 데이터
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);

        return mapping;
    }
}
