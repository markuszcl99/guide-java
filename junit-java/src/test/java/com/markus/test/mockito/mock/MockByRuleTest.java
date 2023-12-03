package com.markus.test.mockito.mock;

import com.markus.domain.dto.AccountDto;
import com.markus.service.AccountLoginService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;

/**
 * @author: markus
 * @date: 2023/12/3 4:30 PM
 * @Description: Rule 是什么
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MockByRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private AccountLoginService accountLoginService;

    @Test
    public void testMock() {
//        AccountLoginService loginService = mock(AccountLoginService.class);
        AccountDto account = accountLoginService.findAccount("x", "x");
        System.out.println(account);
    }
}
