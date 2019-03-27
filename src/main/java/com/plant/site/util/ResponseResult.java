package com.plant.site.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-03-20 16:01
 * @version:1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private Integer code;
    private String msg = ResultEnum.SUCCESS.getMsg();
    private T data;


}
