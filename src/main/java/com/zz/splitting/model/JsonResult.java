package com.zz.splitting.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JsonResult {

    private String code;
    private String msg;
    private Object data;

}
