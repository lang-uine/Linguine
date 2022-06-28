package com.Linguine.domain.member;

import com.Linguine.domain.board.Comments;
import com.Linguine.domain.board.Post;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Entity
@EqualsAndHashCode(of= {"id"}, callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//2022-06-03_yeoooo: 테스트를 위해 임시로 열어둔 Setter,Builder등으로 교체되어야 함 -> 교체완료
public class Member extends BaseTimeEntity implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String email;
    private String nickName;
    private LocalDateTime lastLoginTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return "ROLE_USER";
        });

        //collectors.add(new SimpleGrantedAuthority("Role"));

        return collectors;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }


    @Override//만료되지 않은 계정인지
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override//잠겨있지 않은 계정인지
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override//만료되지 않은 비밀번호인지
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override// 활성화된 계정인지
    public boolean isEnabled() {
        return true;
    }

    @Builder
    public Member(Long id, String email, String name, String nickName,String password, LocalDateTime lastLoginTime) {
        super();
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.lastLoginTime = lastLoginTime;
    }



    @Enumerated(EnumType.STRING)
    private MemberSpec spec;//2022-06-03_yeoooo: 멤버 종류(PROFESSOR, STUDENT)

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comments> comments = new ArrayList<>();


}
