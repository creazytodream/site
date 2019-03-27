package com.plant.site.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @Author: yumingbin@zto.cn
 * @Date: 2019-03-20 16:01
 * @Version:1.0
 **/
@NoArgsConstructor
public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    ERROR(501, "error"),
    SUCCESS(200, "success"),
    USER_NOT_EXIST(400, "用户不存在"),
    USER_IS_EXISTS(401, "用户已存在"),
    DATA_IS_NULL(300, "数据为空"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
