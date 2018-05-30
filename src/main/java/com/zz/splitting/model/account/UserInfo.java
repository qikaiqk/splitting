package com.zz.splitting.model.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {

    private Integer uid;
    private String account;
    private String nickName;
    private String authToken;

}
