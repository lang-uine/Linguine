package com.Linguine.domain.board;

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
    public ReviewPost(String title, String contents,Long owner, int commentsCnt, int hitCnt) {
        super(title, contents,owner,commentsCnt, hitCnt);
    }
}
