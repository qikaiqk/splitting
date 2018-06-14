package com.zz.splitting.entity.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {



    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Account 邮箱地址，不能为空")
    @Email
    @Column(name = "account")
    private String account;

    @Column(name = "nickname")
    private String nickname;

    @NotEmpty(message = "PWD 密码不能为空")
    @Column(name = "pwd")
    private String pwd;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "createAt")
    private Timestamp createAt;

    @Column(name = "updateAt")
    private Timestamp updateAt;

}
