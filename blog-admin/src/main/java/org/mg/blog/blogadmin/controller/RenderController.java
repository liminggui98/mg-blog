package org.mg.blog.blogadmin.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面渲染相关 -- 页面跳转
 */
@Controller
public class RenderController extends BaseController {
    @RequestMapping(value = {StringUtils.EMPTY, "/index"}, method = RequestMethod.GET)
    public String index() {
        return i18n("index");
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String toArticles() {
        return i18n("articles/list");
    }

    @RequestMapping(value = "/charts", method = RequestMethod.GET)
    public String toCharts() {
        return i18n("charts");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return i18n("login");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister() {
        return i18n("register");
    }

    @RequestMapping(value = "/monitor/druid", method = RequestMethod.GET)
    public String toDruidMonitor() {
        return "druid-monitor";
    }
}
