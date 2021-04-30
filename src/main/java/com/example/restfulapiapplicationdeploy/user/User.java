package com.example.restfulapiapplicationdeploy.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value={"password","ssn"}) // json 데이터 반환할때 해당 정보는 가림
@JsonFilter("UserInfo") // 컨트롤러에서 필터링
public class User {
    private Integer id;

    @Size(min=2, message="Name은 2글자 이상 입력해주세요.")
    private String name;
    @Past
    private Date joinDate;

    private String password;
    private String ssn;
}
