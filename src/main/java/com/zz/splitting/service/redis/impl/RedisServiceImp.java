package com.zz.splitting.service.redis.impl;

import com.zz.splitting.service.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceImp implements IRedisService {

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public void storeAccountCookie(String cookie, String account) {
        stringRedisTemplate.opsForValue().set(cookie, account);
    }

    @Override
    public String findAccountByCookie(String cookie) {
        return stringRedisTemplate.opsForValue().get(cookie);
    }
}
