package com.example.Linguine.domain.board;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Date;

@Getter
@RequiredArgsConstructor
public class Post{
    private final Long Post_ID;
    private final Date Posted_Data;
    private final String Post_Owner;
    private final String Post_Title;
    private final String Contents;
    public final String Category;
}
