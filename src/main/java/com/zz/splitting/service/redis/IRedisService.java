package com.zz.splitting.service.redis;

public interface IRedisService {

    void storeAccountCookie(String cookie, String account);

    String findAccountByCookie(String cookie);
}
