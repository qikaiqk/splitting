package com.zz.splitting.util;

import java.util.HashMap;
import java.util.Map;

public class CookieHolder {

    private static final Map<String, String> COOKIE_MAP;

    static {
        COOKIE_MAP = new HashMap<String, String>();
    }

    public static String findAccountByCookie(String cookie) {
        return COOKIE_MAP.get(cookie);
    }

    public static void setAccountByCookie(String cookie, String account) {
        COOKIE_MAP.put(cookie, account);
    }
}
