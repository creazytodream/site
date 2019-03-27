package com.plant.site.controller;

import com.plant.site.model.SysUser;
import com.plant.site.service.ISysUserService;
import com.plant.site.util.ResponseResult;
import com.plant.site.util.ResultEnum;
import com.plant.site.util.ResultUtil;
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
    public SysUser login(HttpSession session, @RequestParam("userName") String userName, @RequestParam("password") String password) {
//        session.setAttribute("userName", userName);
        SysUser sysUser = new SysUser();

        sysUser.setPassword("1");
        sysUser.setUserId(1);
        sysUser.setUserName("name");
        log.info("run");
        return sysUser;
    }


    @GetMapping("/getById")
    public ResponseResult<SysUser> getById(Integer id) {
        SysUser byId = sysUserService.getById(id);
        return ResultUtil.success(byId);
    }

    @PostMapping("/add")
    public int addUser(SysUser user) {
        return sysUserService.insert(user);
    }

    @GetMapping("/deleteSysUserById")
    public int deleteSysUserById(Integer id) {
        return sysUserService.deleteSysUserById(id);
    }

    @PostMapping("/update")
    public  void  update(){

        int i = sysUserService.updateSysUserByUserId(2);

    }

}
