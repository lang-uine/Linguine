package com.Linguine.domain.member;

import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Setter//2022-06-03_yeoooo: 테스트를 위해 임시로 열어둔 Setter,Builder등으로 교체되어야 함
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String public_Id;
    private String name;
    private String password;
    private String ph;
    private String email;
    private String nickName;

    @Enumerated(EnumType.STRING)
    private MemberSpec spec;//멤버 종류(PROFESSOR, STUDENT)

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comments> comments = new ArrayList<>();

}
