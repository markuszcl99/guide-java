package com.markus.test.mockito.staticMethod;

import com.markus.util.UserUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.runners.MockitoJUnitRunner;

import static javafx.beans.binding.Bindings.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mockStatic;

/**
 * @author: markus
 * @date: 2023/12/6 11:23 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@RunWith(MockitoJUnitRunner.class)
public class StaticMethodMockTest {

    private MockedStatic<UserUtil> userUtilMockedStatic;

    @Before
    public void setup() {
        this.userUtilMockedStatic = mockStatic(UserUtil.class);
    }

    @Test
    public void testMyMethod() {
        userUtilMockedStatic.when(() -> UserUtil.getAge(anyLong())).thenReturn(20);
        int age = UserUtil.getAge(10L);
        assertThat(20, equalTo(age));
    }

    @After
    public void destroy() {
        this.userUtilMockedStatic.close();
    }
}