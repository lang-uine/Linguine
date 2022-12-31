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
    public ReviewPost(String title, Category category, String contents,Long owner, int commentsCnt, int hitCnt) {
        super(title, category, contents,owner,commentsCnt, hitCnt);
    }
}
