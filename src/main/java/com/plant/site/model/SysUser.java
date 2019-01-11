package com.plant.site.model;

import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SysUser extends BaseRowModel implements Serializable {
    private Integer id;

    private Integer userId;

    private String userName;

    private String password;
}