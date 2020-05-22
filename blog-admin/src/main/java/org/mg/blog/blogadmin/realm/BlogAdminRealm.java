package org.mg.blog.blogadmin.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.mg.blog.blogadmin.service.LoginService;
import org.mg.blog.blogadmin.service.UserService;
import org.mg.blog.model.Right;
import org.mg.blog.model.Role;
import org.mg.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.security.Permissions;

/**
 * blog admin
 */
public class BlogAdminRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection.getPrimaryPrincipal() == null) {
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (!ObjectUtils.isEmpty(user)) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            for (Role role : user.getRoles()) {
                simpleAuthorizationInfo.addRole(role.getName());
                for (Right right : role.getRights()) {
                    simpleAuthorizationInfo.addStringPermission(right.getRightContent());
                }
            }
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        if (authenticationToken instanceof UsernamePasswordToken) {
            String name = authenticationToken.getPrincipal().toString();
            char[] pass = ((UsernamePasswordToken) authenticationToken).getPassword();
            User user = userService.query(name, pass);
            if (user == null) {
                return null;
            } else {
                SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, pass, getName());
                return simpleAuthenticationInfo;
            }
        }
        return null;
    }
}
