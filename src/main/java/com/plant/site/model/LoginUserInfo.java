package com.plant.site.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserInfo {
    private Long userId;

    private String userName;

    private String passWord;

    private Byte sex;

    private String email;

    private String phone;

    private Byte delFlag;

    private Date lastLoginTime;

    private String lastLoginDevice;

    private String userType;

    private String salt;

    private String lastLoginIp;

    private String token;

    private Integer tokenExp;

    private Byte enable;

    private Date updateDate;

    private Date createDate;

    private String openId;

}