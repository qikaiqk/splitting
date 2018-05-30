package com.zz.splitting.service.account.impl;

import com.zz.splitting.CommonCode;
import com.zz.splitting.entity.account.User;
import com.zz.splitting.model.JsonResult;
import com.zz.splitting.model.account.UserInfo;
import com.zz.splitting.service.account.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements IAccountService {

    @Override
    public Boolean checkExist(String account) {
        // read database
        return Boolean.TRUE;
    }

    //TODO: JsonResult
    @Override
    public JsonResult register(User user) {

        Boolean exist = checkExist(user.getAccount());
        if (exist) {
            return JsonResult
                    .builder()
                    .code(CommonCode.ACCOUNT_ALREADY_EXIST)
                    .msg("账户已存在，注册失败")
                    .build();
        }

        // read the database
        Boolean repoSucc = Boolean.TRUE;
        UserInfo userInfo = UserInfo
                                .builder()
                                .uid(001)
                                .account(user.getAccount())
                                .authToken("fooToken")
                                .build();

        if (repoSucc) {
            return JsonResult
                    .builder()
                    .code(CommonCode.SUCC)
                    .msg("注册成功")
                    .data(userInfo)
                    .build();
        }

        return JsonResult
                .builder()
                .code(CommonCode.DB_ERROR)
                .msg("数据库错误，注册失败")
                .build();

    }

    @Override
    public JsonResult login(User user) {

        Boolean exist = checkExist(user.getAccount());

        if (!exist) {
            return JsonResult
                    .builder()
                    .code(CommonCode.ACCOUNT_NON_EXIST)
                    .msg("用户名不存在，登录失败")
                    .build();
        }

        Boolean pwdValid = checkPwd(user.getAccount(), user.getPwd());
        if (!pwdValid) {
            return JsonResult
                    .builder()
                    .code(CommonCode.INVALID_PWD)
                    .msg("密码不正确，登录失败")
                    .build();
        }

        return JsonResult
                .builder()
                .code(CommonCode.SUCC)
                .msg("用户名密码正确，登录成功")
                .data("fooToken")
                .build();

    }

    @Override
    public JsonResult loginByToken(String token) {
        // read database
        Boolean tokenCheckRepoSucc = Boolean.FALSE;
        if (tokenCheckRepoSucc) {
            return JsonResult
                    .builder()
                    .code(CommonCode.SUCC)
                    .msg("token通过验证，登录成功")
                    .data(token)
                    .build();
        }
        return JsonResult
                .builder()
                .code(CommonCode.AUTH_FORBIDDEN)
                .msg("token无效，登录失败")
                .build();
    }



    private Boolean checkPwd(String account, String pwd) {
        // read database
        return Boolean.TRUE;
    }
}
