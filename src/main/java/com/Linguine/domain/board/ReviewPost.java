package com.Linguine.domain.board;

import com.Linguine.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@DiscriminatorValue("review")
@NoArgsConstructor
public class ReviewPost extends Post{
    @Builder
    public ReviewPost(String title, String contents, Member writer, int commentsCnt, int hitCnt) {
        super(title, contents, writer, commentsCnt, hitCnt);
    }
}
