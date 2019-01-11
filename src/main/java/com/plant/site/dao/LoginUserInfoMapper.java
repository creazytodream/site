package com.plant.site.dao;

import com.plant.site.model.LoginUserInfo;

public interface LoginUserInfoMapper {
    int insert(LoginUserInfo record);

    int insertSelective(LoginUserInfo record);
}