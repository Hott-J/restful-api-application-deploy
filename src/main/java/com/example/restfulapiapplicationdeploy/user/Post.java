package com.example.restfulapiapplicationdeploy.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // User : Post -> 1 : (0~N), Main : Sub -> Parent : Child
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 방식. 사용자 엔티티를 조회할 때, 매번 포스트 데이터를 조회하는 것이 아니라,
    // 포스트 데이터가 필요한 시점에 사용자 데이터를 가져옴
    @JsonIgnore
    private User user;

}
