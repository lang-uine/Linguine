package com.Linguine.domain.board;

import com.Linguine.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


//@Setter
//2022-05-08_yeoooo : 테스트를 위해 잠시 열어두는 setter
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//2022-05-08_yeoooo: Inheritance 어노테이션을 통해 PK를 자손클래스에 전해줄 수 있음
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ptype")
public abstract class Post{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    //2022_06_03_yeoooo-포스트와 멤버는 N:1연관관계
    @JoinColumn(name = "member_id")
    private Member member;


    private String posted_Date = getNow();

    private String owner;
    private String title;
    private String contents;
    private int commentsCnt;


    @OneToMany(mappedBy = "post")//, cascade = CascadeType.ALL)
    public List<Comments> comments = new ArrayList<>();

    public void addCountComment(int cnt) {
        this.commentsCnt += 1;
    }

    public String getNow() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


}
