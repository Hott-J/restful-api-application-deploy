package com.example.restfulapiapplicationdeploy.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// HTTP Status Code
// 2xx -> OK
// 4xx -> Client 오류 (권한없거나 메소드 지원안되거나 리소스 없거나 등)
// 5xx -> Server 오류
@ResponseStatus(HttpStatus.NOT_FOUND) // 500 -> 404 오류로 변경
public class UserNotFoundExcetion extends RuntimeException {
    public UserNotFoundExcetion(String message) {
        super(message);
    }
}
