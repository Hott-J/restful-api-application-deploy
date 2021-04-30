package com.example.restfulapiapplicationdeploy.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password","ssn"}) // json 데이터 반환할때 해당 정보는 가림
@JsonFilter("UserInfo") // 컨트롤러에서 필터링
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체") // 스웨거 문서에 설명 추가
public class User {
    private Integer id;

    @Size(min=2, message="Name은 2글자 이상 입력해주세요.")
    @ApiModelProperty(notes = "사용자 이름을 입력해주세요.")
    private String name;
    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해주세요.")
    private Date joinDate;

    @ApiModelProperty(notes = "사용자 비밀번호를 입력해주세요.")
    private String password;
    @ApiModelProperty(notes = "사용자 주민번호를 입력해주세요.")
    private String ssn;
}
