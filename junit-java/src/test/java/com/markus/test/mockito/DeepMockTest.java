package com.markus.test.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * @author: markus
 * @date: 2023/12/3 4:34 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DeepMockTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private MockitoService mockitoService;

//    @Mock
//    private MockitoObject mockitoObject;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeepMock() {
        mockitoService.get().foo();
    }


    @Test
    public void testNormalMock() {
//        when(mockitoService.get()).thenReturn(mockitoObject);
////        MockitoObject mockitoObject = mockitoService.get();
//        mockitoObject.foo();
    }
}
