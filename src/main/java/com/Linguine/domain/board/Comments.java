package com.Linguine.domain.board;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;

@NoArgsConstructor
@ToString(callSuper = true)
public class Comments{
    private String author;
    private Date commented_Date;
    private Long related_Post;
    private String contents;
    private String comment_password;

}
