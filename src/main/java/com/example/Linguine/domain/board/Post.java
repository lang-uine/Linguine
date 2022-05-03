package com.example.Linguine.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class Post {
    private final Long Post_ID;
    private Date Posted_Data;
    private String Post_Owner;
    private String Post_Title;
    private String Contents;
    public String Category;
}
