package com.zz.splitting.service.account.impl;

import com.zz.splitting.CommonCode;
import com.zz.splitting.entity.account.User;
import com.zz.splitting.exception.account.DBException;
import com.zz.splitting.exception.account.UserException;
import com.zz.splitting.model.JsonResult;
import com.zz.splitting.model.account.UserInfo;
import com.zz.splitting.service.account.IAccountService;
import com.zz.splitting.service.account.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class AccountServiceImp implements IAccountService {

    @Autowired
    private IUserService userService;



    @Override
    public JsonResult checkExist(String account) {

        User userByAccount = userService.findUserByAccount(account);

        if (userByAccount != null) {

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

    @Override
    public JsonResult register(User user) throws Exception{

        // 查用户是否已存在
        if (checkExist(user.getAccount()).getCode() == CommonCode.ACCOUNT_ALREADY_EXIST) {
            return checkExist(user.getAccount());
        }

        // create新用户
        User registeredUser;

        try {
            registeredUser = userService.createNewUser(user);
        } catch (Exception e) {
            return handleException(e);
        }

        UserInfo userInfo = UserInfo
                .builder()
                .uid(registeredUser.getId())
                .account(registeredUser.getAccount())
                .authToken("fooToken")
                .build();
        return JsonResult
                .builder()
                .code(CommonCode.SUCC)
                .msg("注册成功")
                .data(userInfo)
                .build();
    }

    @Override
    public JsonResult login(User user) {

        // 查是否用户存在
        if (checkExist(user.getAccount()).getCode() != CommonCode.ACCOUNT_ALREADY_EXIST) {
            return JsonResult
                    .builder()
                    .code(CommonCode.ACCOUNT_NON_EXIST)
                    .msg("用户名不存在，登录失败")
                    .build();
        }

        // 验证密码
        if (userService.checkPwd(user)) {
            return JsonResult
                    .builder()
                    .code(CommonCode.SUCC)
                    .msg("用户名密码正确，登录成功")
                    .data("fooToken")
                    .build();

        }

        return JsonResult
                .builder()
                .code(CommonCode.INVALID_PWD)
                .msg("密码不正确，登录失败")
                .build();

    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private JsonResult handleException(Exception e) throws Exception {

        if (e instanceof DBException) {
            return JsonResult
                    .builder()
                    .code(CommonCode.SYS_ERR)
                    .msg(e.getMessage())
                    .build();
        }

        throw new UserException("其他用户错误");

    }
}
