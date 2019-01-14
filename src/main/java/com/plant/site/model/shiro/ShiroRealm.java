package com.plant.site.model.shiro;

import com.plant.site.dao.UPermissionDao;
import com.plant.site.dao.URoleDao;
import com.plant.site.dao.UUserDao;
import com.plant.site.model.UPermission;
import com.plant.site.model.URole;
import com.plant.site.model.UUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/14 10:52
 * @version:1.0
 **/
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    //一般这里都写的是servic，这里省略直接调用dao
    @Autowired
    private UUserDao uUserDao;
    @Autowired
    private URoleDao uRoleDao;
    @Autowired
    private UPermissionDao uPermissionDao;

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        log.info("验证当前Subject时获取到token为：" + token.toString());
        //查出是否有此用户
        String username = token.getUsername();
        UUser hasUser = uUserDao.selectAllByName(username);

        if (hasUser != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            List<URole> rlist = uRoleDao.findRoleByUid(hasUser.getId());//获取用户角色
            List<UPermission> plist = uPermissionDao.findPermissionByUid(hasUser.getId());//获取用户权限
            List<String> roleStrlist = new ArrayList<String>();////用户的角色集合
            List<String> perminsStrlist = new ArrayList<String>();//用户的权限集合
            for (URole role : rlist) {
                roleStrlist.add(role.getName());
            }
            for (UPermission uPermission : plist) {
                perminsStrlist.add(uPermission.getName());
            }
            hasUser.setPerminsList(perminsStrlist);
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            return new SimpleAuthenticationInfo(hasUser, hasUser.getPswd(), getName());
        }

        return null;
    }

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("##################执行Shiro权限认证##################");
        UUser user = (UUser) principalCollection.getPrimaryPrincipal();
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getPerminsList());
            //用户的权限集合
            info.addStringPermissions(user.getPerminsList());

            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }
}
