package com.plant.site.dao;

import com.plant.site.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int insert(SysUser record);

    SysUser getById(@Param("userId") Integer id);


    List<SysUser> selectAll();

    int updateSysUserByUserId(@Param("userId") Integer id);

    int deleteSysUserById(@Param("id") Integer id);
}