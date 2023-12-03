package com.markus.controller;

import com.markus.domain.dto.AccountDto;
import com.markus.service.AccountLoginService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: markus
 * @date: 2023/12/3 4:05 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AccountLoginController {

    private AccountLoginService accountLoginService;

    public AccountLoginController(AccountLoginService accountLoginService) {
        this.accountLoginService = accountLoginService;
    }

    public AccountDto login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return accountLoginService.findAccount(username, password);
    }
}
