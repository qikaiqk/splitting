package com.zz.splitting.repo;

import com.zz.splitting.entity.account.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByAccount(String account);

    @Override
    User getOne(Integer id);

    User save(User user);
}
