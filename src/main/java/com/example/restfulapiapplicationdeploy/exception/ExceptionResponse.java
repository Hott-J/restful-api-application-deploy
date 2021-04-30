package com.example.restfulapiapplicationdeploy.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

// pojo 객체로 예외 전달
// 기존에 trace가 출력되서 이를 감추기 위해 만듦
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
