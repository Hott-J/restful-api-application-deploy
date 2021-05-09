package com.example.restfulapiapplicationdeploy.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password","ssn"}) // json 데이터 반환할때 해당 정보는 가림
//@JsonFilter("UserInfo") // 컨트롤러에서 필터링
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체") // 스웨거 문서에 설명 추가
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message="Name은 2글자 이상 입력해주세요.")
    @ApiModelProperty(notes = "사용자 이름을 입력해주세요.")
    private String name;
    @Past
    @ApiModelProperty(notes = "사용자 등록일을 입력해주세요.")
    private Date join_Date;

    @ApiModelProperty(notes = "사용자 비밀번호를 입력해주세요.")
    private String password;
    @ApiModelProperty(notes = "사용자 주민번호를 입력해주세요.")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int id, String name, Date join_Date, String password, String ssn) {
        this.id=id;
        this.name=name;
        this.join_Date=join_Date;
        this.password=password;
        this.ssn=ssn;
    }
}
