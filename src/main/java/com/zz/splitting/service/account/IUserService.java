package com.zz.splitting.service.account;

import com.zz.splitting.entity.account.User;

public interface IUserService {

    User findUserByAccount(String account);

    User findUserById(Integer id);

    User createNewUser(User user) throws Exception;

    Boolean checkPwd(User user);

}
