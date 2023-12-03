package com.markus.test.mockito.stubbing;

/**
 * @author: markus
 * @date: 2023/12/3 5:02 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class StubbingService {

    public int getI() {
        System.out.println("=======getI()=======");
        return 10;
    }

    public String getS() {
        System.out.println("=======getS()=======");
        throw new RuntimeException();
    }
}
