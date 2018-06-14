package com.zz.splitting.util;

import com.zz.splitting.entity.account.User;

public class UserHolder {

    private static ThreadLocal<User> USER_HOLDER = new ThreadLocal<>();

    public static User getUser() {
        return USER_HOLDER.get();
    }

    public static void setUser(User user) {
        USER_HOLDER.set(user);
    }
}
