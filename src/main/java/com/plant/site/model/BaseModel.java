package com.plant.site.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/11 14:51
 * @version:1.0
 **/
@Data
public class BaseModel implements Serializable {
    /**
     * ID
     */
    private String id;
    /**
     * 是否有效
     */
    private Boolean valid;
    /**
     * 由谁创建
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改者
     */
    private String updateBy;
    /**
     * 最后修改时间
     */
    private Date updateTime;
}
