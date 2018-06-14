package com.zz.splitting.service.account;

import com.zz.splitting.entity.account.User;
import com.zz.splitting.model.JsonResult;

public interface IAccountService {

    JsonResult checkExist(String account);

    JsonResult register(User user) throws Exception;

    JsonResult login(User user);
}
