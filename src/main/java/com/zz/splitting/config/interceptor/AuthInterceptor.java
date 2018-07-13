package com.zz.splitting.config.interceptor;

import com.zz.splitting.entity.account.User;
import com.zz.splitting.service.account.IUserService;
import com.zz.splitting.service.redis.IRedisService;
import com.zz.splitting.util.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final String AUTH_HEADER = "X-Auth";

    @Autowired
    private IUserService userService;

    @Autowired
    private IRedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取 cookie
        String cookie = request.getHeader(AUTH_HEADER);

        // 换取 user，检查cookie的有效性？
        String userAccount = redisService.findAccountByCookie(cookie);
        User currentUser = userService.findUserByAccount(userAccount);

        // ThreadLocal 放入 user
        if (currentUser == null) {
            return false;
        }

        UserHolder.setUser(currentUser);
        return true;
    }
}
