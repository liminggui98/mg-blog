package org.mg.blog.blogadmin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.mg.blog.blogadmin.service.LoginService;
import org.mg.blog.entity.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.mg.blog.constants.BlogConstants.*;

@Controller
public class LoginController extends BaseController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String doLogin(UserVo user, Model model) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                    user.getUserName(),
                    user.getPass()
            );
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException | AuthorizationException e) {
            model.addAttribute(LOGIN_FAILED_FLAG, true);
            return LOGIN_TEMPLATE_NAME;
        }
        return INDEX_TEMPLATE_NAME;
    }


    @RequestMapping(value = LOGOUT_TEMPLATE_NAME, method = RequestMethod.GET)
    public String doLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return i18n(LOGIN_TEMPLATE_NAME);
    }
}
