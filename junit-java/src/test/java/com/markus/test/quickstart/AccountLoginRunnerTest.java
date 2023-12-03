package com.markus.test.quickstart;

import com.markus.controller.AccountLoginController;
import com.markus.domain.dto.AccountDto;
import com.markus.service.AccountLoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author: markus
 * @date: 2023/12/3 4:11 PM
 * @Description: 用户登录功能单元测试
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginRunnerTest {
    private AccountLoginController accountLoginController;
    private AccountLoginService accountLoginService;
    private HttpServletRequest httpServletRequest;


    @Before
    public void setup() {
        this.accountLoginService = Mockito.mock(AccountLoginService.class);
        this.httpServletRequest = Mockito.mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountLoginService);
    }

    @Test
    public void testAccountLogin() {
        AccountDto accountDto = new AccountDto();

        when(httpServletRequest.getParameter("username")).thenReturn("markuszhang");
        when(httpServletRequest.getParameter("password")).thenReturn("123456");
        when(accountLoginService.findAccount(anyString(), anyString())).thenReturn(accountDto);

        assertThat(accountLoginController.login(httpServletRequest), equalTo(accountDto));
    }
}
