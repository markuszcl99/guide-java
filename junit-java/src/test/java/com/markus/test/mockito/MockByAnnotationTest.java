package com.markus.test.mockito;

import com.markus.domain.dto.AccountDto;
import com.markus.service.AccountLoginService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author: markus
 * @date: 2023/12/3 4:28 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MockByAnnotationTest {

    @Mock
    private AccountLoginService accountLoginService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAnnotation() {
        AccountDto account = accountLoginService.findAccount("x", "x");
        System.out.println(account);
    }
}
