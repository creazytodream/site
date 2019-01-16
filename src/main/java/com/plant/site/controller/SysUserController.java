package com.plant.site.controller;

import com.plant.site.aspect.NeedManagerPower;
import com.plant.site.model.SysUser;
import com.plant.site.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/11 11:04
 * @version:1.0
 **/
@Slf4j
@RestController
@RequestMapping("sysUser")
public class SysUserController {


    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("login")
    @NeedManagerPower
    public SysUser login(HttpSession session, @RequestParam("userName") String userName, @RequestParam("password") String password) {
//        session.setAttribute("userName", userName);
        SysUser sysUser = new SysUser();

        sysUser.setPassword("1");
        sysUser.setUserId(1);
        sysUser.setUserName("name");
        log.info("run");
        return sysUser;
    }


    @GetMapping("getById")
    public SysUser getById(Integer id) {

        return sysUserService.getById(id);


    }

    @PostMapping("/add")
    public int addUser(SysUser user) {
        return sysUserService.insert(user);
    }

}
