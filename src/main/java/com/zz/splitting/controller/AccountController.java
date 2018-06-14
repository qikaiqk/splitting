package com.zz.splitting.controller;

import com.zz.splitting.CommonCode;
import com.zz.splitting.entity.account.User;
import com.zz.splitting.exception.account.UserException;
import com.zz.splitting.model.JsonResult;
import com.zz.splitting.service.account.IAccountService;
import com.zz.splitting.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/account/{v1}")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/register/check", method = RequestMethod.GET)
    public JsonResult checkAccountExist(@RequestParam String account) {

        return accountService.checkExist(account);

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(@Valid @RequestBody User user,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return JsonResult
                    .builder()
                    .code(CommonCode.PARA_ERROR)
                    .msg(bindingResult.getAllErrors().get(0).getDefaultMessage())
                    .build();
        }

        try {
            return accountService.register(user);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(@Valid @RequestBody User user,
                            BindingResult bindingResult) {

        // 是否cookie验证已通过
        if (UserHolder.getUser() != null) {
            return JsonResult
                    .builder()
                    .code(CommonCode.SUCC)
                    .msg("Cookie验证通过，登录成功")
                    .build();
        }

        if (bindingResult.hasErrors()) {
            return JsonResult
                    .builder()
                    .code(CommonCode.PARA_ERROR)
                    .msg(bindingResult.getAllErrors().get(0).getDefaultMessage())
                    .build();
        }

        return accountService.login(user);


    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private JsonResult handleException(Exception e) {
        if (e instanceof UserException) {
            return JsonResult
                    .builder()
                    .code(CommonCode.SYS_ERR)
                    .msg(e.getMessage())
                    .build();
        }
        return null;
    }
}
