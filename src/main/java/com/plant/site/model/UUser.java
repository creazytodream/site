package com.plant.site.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UUser  implements Serializable {
    private Long id;

    private List<String> perminsList;// 一个用户具有多个角色

    private String nickname;

    private String email;

    private String pswd;

    private Date createTime;

    private Date lastLoginTime;

    private Long status;

}