package com.Linguine.domain.board;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue("review_P")
public class ReviewPost extends Post{
}
