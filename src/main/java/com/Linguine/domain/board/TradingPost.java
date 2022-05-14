package com.Linguine.domain.board;

import lombok.ToString;

import javax.persistence.*;


@ToString(callSuper = true)
@Entity
@DiscriminatorValue("trading_post")
public class TradingPost extends Post {
    private int price;
    private boolean isBuying;
    private boolean isExpired;
}
