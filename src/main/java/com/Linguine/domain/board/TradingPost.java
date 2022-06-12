package com.Linguine.domain.board;

import lombok.ToString;

import javax.persistence.*;


@ToString(callSuper = true)
@Entity
@DiscriminatorValue("T")
public class TradingPost extends Post {
    private int price;
    private boolean isBuying;
    private boolean isExpired;
}
