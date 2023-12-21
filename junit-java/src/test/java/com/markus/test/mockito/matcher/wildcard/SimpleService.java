package com.markus.test.mockito.matcher.wildcard;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author: markus
 * @date: 2023/12/3 5:44 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class SimpleService {
    public int method1(int i, String s, Collection<?> c, Serializable serializable) {
        throw new RuntimeException();
    }

    public void method2(int i, String s, Collection<?> c, Serializable serializable) {
        throw new RuntimeException();
    }
}
