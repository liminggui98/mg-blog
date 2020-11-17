
package org.mg.blog.resource.controller;

import static org.mg.blog.resource.constants.Url.RESOURCE_URL;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.base.controller.BaseController;
import org.mg.blog.resource.service.ResourceService;
import org.mg.blog.system.dto.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 功能描述
 *
 * @since 2020-09-26
 */
@Controller
@RequestMapping(value = RESOURCE_URL)
public class ResourceController extends BaseController<ResourceService, Resource> {
    @Override
    @GetMapping("/add")
    public ModelAndView toAdd() {
        return createView("resource/add");
    }

    @Override
    @GetMapping("/{id}")
    public ModelAndView query(String id) {
        ModelAndView detail = super.query(id);
        detail.setViewName("resource/details");
        return detail;
    }

    @Override
    @GetMapping
    public ModelAndView toList() {
        return createView("resource/list");
    }

    @Override
    @ResponseBody
    @PostMapping("/list")
    public Page<Resource> queryList(Page<Resource> page) {
        List<Resource> resourceList = service.queryResource();

        Page<Resource> resultPage = new Page<>();
        resultPage.setRecords(resourceList);
        return resultPage;
    }
}
