package com.aku.pojo.resp;

import lombok.Data;

@Data
public class BaseResp {
    private Integer code;

    private Object data;

    private String message;

    private long total;
}
