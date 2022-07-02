package com.Linguine.domain.board;

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
    public FreePost(String title, String contents, Long owner, int commentsCnt, int hitCnt) {
        super(title, contents, owner, commentsCnt, hitCnt);
    }
}