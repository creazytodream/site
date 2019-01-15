package com.plant.site.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserExcelModel extends BaseRowModel implements Serializable {

    @ExcelProperty(value = "用户ID",index = 0)
    private Integer userId;
    @ExcelProperty(value = "用户名",index = 1)
    private String userName;
    @ExcelProperty(value = "密码",index = 2)
    private String password;
}