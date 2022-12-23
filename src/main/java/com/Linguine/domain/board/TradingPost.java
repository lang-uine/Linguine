package com.Linguine.domain.board;

import com.Linguine.domain.member.Member;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import java.time.LocalDateTime;


@ToString(callSuper = true)
@Entity
@DiscriminatorValue("trade")
@NoArgsConstructor
public class TradingPost extends Post {
    private int price;
    private boolean isBuying;
    private boolean isExpired;

    @Builder
<<<<<<< HEAD
    public TradingPost(String title, String contents, Member writer, int commentsCnt, int hitCnt, int price, boolean isBuying, boolean isExpired) {
        super(title,contents,writer, commentsCnt, hitCnt);
=======
    public TradingPost(String title,String contents, Category category, Long owner, int commentsCnt, int hitCnt, int price, boolean isBuying, boolean isExpired) {
        super(title,category, contents, owner, commentsCnt, hitCnt);
>>>>>>> cbe4720783716bc62b6bc726abec4aecf72ea603
        this.price = price;
        this.isBuying = false;
        this.isExpired = false;
    }

}
