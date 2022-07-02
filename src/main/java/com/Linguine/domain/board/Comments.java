package com.Linguine.domain.board;

import com.Linguine.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
//@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime commented_Date;
    private String contents;
    private String comment_password;

    @Builder
    public Comments(Long id, Post post, Member member, LocalDateTime commented_Date, String contents, String comment_password) {
        this.id = id;
        this.post = post;
        this.member = member;
        this.commented_Date = commented_Date;
        this.contents = contents;
        this.comment_password = comment_password;
    }


}
