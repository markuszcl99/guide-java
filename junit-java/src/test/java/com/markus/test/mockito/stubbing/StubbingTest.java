package com.markus.test.mockito.stubbing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * @author: markus
 * @date: 2023/12/3 4:45 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */

@RunWith(MockitoJUnitRunner.class)
public class StubbingTest {

    private List<String> list;

    @Before
    public void init() {
        this.list = mock(ArrayList.class);
    }

    @Test
    public void howToUseStubbing() {
        when(list.get(0)).thenReturn("first");
        assertThat(list.get(0), equalTo("first"));

        when(list.get(anyInt())).thenThrow(new RuntimeException());

        try {
            String s = list.get(0);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void howToStubbingVoidMethod() {
        doNothing().when(list).clear();
        list.clear();
        // 如何判断 执行了返回值为 void 方法
        verify(list, times(1)).clear();

        doThrow(RuntimeException.class).when(list).clear();

        try {
            list.clear();
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(RuntimeException.class));
        }
    }

    @Test
    public void stubbingDoReturn() {
        when(list.get(0)).thenReturn("first");
        doReturn("second").when(list).get(1);
        assertThat(list.get(0), equalTo("first"));
        assertThat(list.get(1), equalTo("second"));
    }

    @Test
    public void iterateSubbing() {
//        when(list.size()).thenReturn(1).thenReturn(2).thenReturn(3).thenReturn(4); // 与下面语句等价
        when(list.size()).thenReturn(1, 2, 3, 4);

        assertThat(list.size(), equalTo(1));
        assertThat(list.size(), equalTo(2));
        assertThat(list.size(), equalTo(3));
        assertThat(list.size(), equalTo(4));
        assertThat(list.size(), equalTo(4));
    }

    @Test
    public void stubbingWithAnswer() {
        when(list.get(anyInt())).thenAnswer(invocationOnMock -> {
            Integer index = invocationOnMock.getArgumentAt(0, Integer.class);
            return String.valueOf(index * 10);
        });

        assertThat(list.get(1), equalTo("10"));
    }

    @Test
    public void stubbingWithRealCall() {
        StubbingService stubbingService = mock(StubbingService.class);
//        System.out.println(stubbingService.getClass());
//        stubbingService.getS();
//        int i = stubbingService.getI();
//        System.out.println(i);

        when(stubbingService.getS()).thenReturn("Alex");
        assertThat(stubbingService.getS(), equalTo("Alex"));

        // stubbingService#getI() 返回真正的值
        when(stubbingService.getI()).thenCallRealMethod();
        assertThat(stubbingService.getI(), equalTo(10));
    }

    @After
    public void destroy() {
        reset(this.list);
    }

}
