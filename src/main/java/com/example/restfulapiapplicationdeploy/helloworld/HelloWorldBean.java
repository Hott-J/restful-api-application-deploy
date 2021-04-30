package com.example.restfulapiapplicationdeploy.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 변수로 생성자 만듦
@NoArgsConstructor // 디폴트 생성자
public class HelloWorldBean {
    private String message;

}
