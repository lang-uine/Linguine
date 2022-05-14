package com.Linguine.domain.board;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
//@Setter
//2022-05-08_yeoooo : 테스트를 위해 잠시 열어두는 setter
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//2022-05-08_yeoooo: Inheritance 어노테이션을 통해 PK를 자손클래스에 전해줄 수 있음
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@Setter
@ToString
@Entity
public class Post{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long post_id;

    private Date posted_Data;
    private String post_Owner;
    private String post_Title;
    private String contents;
    private String category;
}
