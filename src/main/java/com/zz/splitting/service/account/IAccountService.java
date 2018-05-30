package com.zz.splitting.service.account;

import com.zz.splitting.entity.account.User;
import com.zz.splitting.model.JsonResult;
import com.zz.splitting.model.account.UserInfo;

public interface IAccountService {
    Boolean checkExist(String account);

    JsonResult register(User user);

    JsonResult loginByToken(String token);
    JsonResult login(User user);
}
