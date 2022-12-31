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
    public TradingPost(String title,String contents, Category category, Long owner, int commentsCnt, int hitCnt, int price, boolean isBuying, boolean isExpired) {
        super(title,category, contents, owner, commentsCnt, hitCnt);
        this.price = price;
        this.isBuying = false;
        this.isExpired = false;
    }

}
