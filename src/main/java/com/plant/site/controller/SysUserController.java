package com.plant.site.controller;

import com.plant.site.model.SysUser;
import com.plant.site.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/11 11:04
 * @version:1.0
 **/
@RestController
@RequestMapping("sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("getById")
    public SysUser getById(Integer id) {

        SysUser byId = sysUserService.getById(id);
        return byId;


    }

    @PostMapping("/add")
    public int addUser(SysUser user) {
        return sysUserService.insert(user);
    }

}
