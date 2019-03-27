package com.plant.site.service.impl;

import com.plant.site.dao.SysUserMapper;
import com.plant.site.model.SysUser;
import com.plant.site.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/11 10:54
 * @version:1.0
 **/
@Slf4j
@CacheConfig(cacheNames = {"SysUser"})
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;


    @Override
    @Cacheable
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    @Cacheable(key = "'SysUser_'+#id", value = "SysUser")
    public SysUser getById(Integer id) {

        return sysUserMapper.getById(id);
    }


    /**
     * @return
     * @desctiption CachePut 方法不会每次去检查在缓存中是否存在数据，每次都会去执行该方法，把结果集放在缓存中
     */
    @Override
//    @CachePut
    @Transactional
    public int updateSysUserByUserId(Integer userId) {
        SysUser sysUser1=SysUser.builder().id(1).userName("1111").userId(1).password("password").build();
        SysUser sysUser2=SysUser.builder().id(2).userName("2222").userId(2).build();
        int i = sysUserMapper.updateSysUserByUserId(sysUser1);
        int o = sysUserMapper.updateSysUserByUserId(sysUser2);
        log.info("i {},o { }", i, o);
        return i;

    }

    @Override
    @Cacheable
    public List<SysUser> selectAll() {
        return sysUserMapper.selectAll();
    }

    /**
     * @return
     * @desctiption CacheEvict 清除缓存
     */
    @Override
    @CacheEvict
    public int deleteSysUserById(Integer id) {
        return sysUserMapper.deleteSysUserById(id);
    }


}
