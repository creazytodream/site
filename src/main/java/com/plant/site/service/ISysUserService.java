package com.plant.site.service;

import com.plant.site.model.SysUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/11 10:54
 * @version:1.0
 **/

public interface ISysUserService {
    int insert(SysUser record);


    SysUser getById(Integer id);


    int updateSysUserByUserId(@Param("userId") Integer userId);

    List<SysUser> selectAll();

    int deleteSysUserById(Integer id);

}
