package com.example.restfulapiapplicationdeploy.user;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
//@JsonIgnoreProperties(value={"password","ssn"}) // json 데이터 반환할때 해당 정보는 가림
@JsonFilter("UserInfoV2") // 컨트롤러에서 필터링
@NoArgsConstructor
public class UserV2 extends User{
    private String grade;
}
