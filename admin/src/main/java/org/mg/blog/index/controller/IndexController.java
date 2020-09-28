
package org.mg.blog.index.controller;

import org.mg.blog.index.constants.Url;
import org.mg.blog.index.constants.View;
import org.mg.blog.system.api.ResourcesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页转发器
 *
 * @since 2020-09-23
 */
@Controller
public class IndexController {

    @Autowired
    private ResourcesApi resourcesApi;

    /**
     * 首页
     *
     * @param modelAndView 视图对象
     * @return 首页视图
     */
    @RequestMapping(value = {Url.INDEX_URL, Url.HOME_URL, Url.FIRST_URL}, method = RequestMethod.GET)
    public ModelAndView toIndex(ModelAndView modelAndView) {
        modelAndView.setViewName(View.INDEX_VIEW);
        return modelAndView;
    }
}
