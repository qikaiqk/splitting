package com.zz.splitting.controller;

import com.zz.splitting.CommonCode;
import com.zz.splitting.entity.account.User;
import com.zz.splitting.model.JsonResult;
import com.zz.splitting.model.account.UserInfo;
import com.zz.splitting.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account/{v1}")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/register/check", method = RequestMethod.GET)
    public JsonResult checkAccountExist(@RequestParam String account) {
        Boolean exist = accountService.checkExist(account);
        if(exist) {
            return JsonResult
                    .builder()
                    .code(CommonCode.ACCOUNT_ALREADY_EXIST)
                    .msg("账户已存在")
                    .build();
        }

        return JsonResult
                .builder()
                .code(CommonCode.SUCC)
                .msg("账户不存在")
                .build();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody User user) {

        return accountService.register(user);

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody User user,
                            @RequestHeader("X-Auth") String token) {

        // user notnull validation should be done in the interceptor
        if (user.getAccount() != "" && user.getPwd() != "") {
            return accountService.login(user);
        }

        return accountService.loginByToken(token);


    }

}
