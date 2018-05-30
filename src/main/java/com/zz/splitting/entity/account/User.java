package com.zz.splitting.entity.account;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {

    private Integer id;
    private String account;
    private String nickname;
    private String pwd;
    private String avatar;
    private Timestamp createAt;
    private Timestamp updateAt;

}
