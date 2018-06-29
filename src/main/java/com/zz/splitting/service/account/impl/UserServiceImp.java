package com.zz.splitting.service.account.impl;

import com.zz.splitting.entity.account.User;
import com.zz.splitting.exception.account.DBException;
import com.zz.splitting.repo.UserRepo;
import com.zz.splitting.service.account.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User findUserByAccount(String account) {
        return userRepo.findByAccount(account);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public User createNewUser(User user) throws Exception {

        try {
            return userRepo.save(user);
        } catch (RuntimeException e) {
            throw new DBException("数据库错误，用户注册失败");
        }
    }

    @Override
    public Boolean checkPwd(User user) {
        User repoUser = userRepo.findByAccount(user.getAccount());
        if (repoUser.getPwd() == user.getPwd()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
