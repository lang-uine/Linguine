package com.Linguine.domain.board;

import com.Linguine.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("free")
@Getter
@NoArgsConstructor
public class FreePost extends Post {
    @Builder
<<<<<<< HEAD
    public FreePost(String title, String contents, Member writer, int commentsCnt, int hitCnt) {
        super(title, contents, writer, commentsCnt, hitCnt);
=======
    public FreePost(String title, Category category, String contents, Long owner, int commentsCnt, int hitCnt) {
        super(title, category, contents, owner, commentsCnt, hitCnt);

>>>>>>> cbe4720783716bc62b6bc726abec4aecf72ea603
    }
}