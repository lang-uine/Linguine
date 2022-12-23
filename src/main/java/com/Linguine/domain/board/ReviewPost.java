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
<<<<<<< HEAD
    public ReviewPost(String title, String contents, Member writer, int commentsCnt, int hitCnt) {
        super(title, contents, writer, commentsCnt, hitCnt);
=======
    public ReviewPost(String title, Category category, String contents,Long owner, int commentsCnt, int hitCnt) {
        super(title, category, contents,owner,commentsCnt, hitCnt);
>>>>>>> cbe4720783716bc62b6bc726abec4aecf72ea603
    }
}
