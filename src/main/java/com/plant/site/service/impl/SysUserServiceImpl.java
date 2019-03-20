package com.plant.site.service.impl;

import com.plant.site.dao.SysUserMapper;
import com.plant.site.model.SysUser;
import com.plant.site.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/11 10:54
 * @version:1.0
 **/
@Slf4j
@CacheConfig(cacheNames = "Users")
@Service
public  class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;


    @Override
    @Cacheable
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    @Cacheable(key = "#SysUser.id",value = "#id+SysUser")
    public SysUser getById(Integer id) {

        return sysUserMapper.getById(id);
    }


    @Override
    @CachePut
    public int updateSysUserByUserId(Integer userId) {

        return  sysUserMapper.updateSysUserByUserId(userId);

    }

    @Override
    @Cacheable
    public List<SysUser> selectAll() {
        return sysUserMapper.selectAll();
    }


}
