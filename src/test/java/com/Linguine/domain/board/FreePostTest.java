package com.Linguine.domain.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreePostTest {

    @Test
    public void FreePostTest() throws Exception {
        //given
        FreePost post = FreePost.builder().title("gd").build();
        //when
        System.out.println("post = " + post);
        //then

    }

}