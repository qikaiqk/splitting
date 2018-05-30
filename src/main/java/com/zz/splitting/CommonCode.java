package com.zz.splitting;

public class CommonCode {

    /*
    成功|S000
    |
    系统错误|E001
    权限不足|E002
    参数不全|E010
    |
    账户不存在      |U001
    密码错误        |U002
    账户已经存在    |U003
    密码不符合要求  |U004
     */

    public static final String SUCC = "S000";

    public static final String SYS_ERR = "E001";
    public static final String AUTH_FORBIDDEN = "E002";
    public static final String PARA_ERROR = "E003";

    public static final String ACCOUNT_NON_EXIST = "U001";
    public static final String WRONG_PWD = "U002";
    public static final String ACCOUNT_ALREADY_EXIST = "U003";
    public static final String INVALID_PWD = "U004";

    public static final String DB_ERROR = "DB001_TEMP";

}
