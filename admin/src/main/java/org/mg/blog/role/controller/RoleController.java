
package org.mg.blog.role.controller;

import static org.mg.blog.role.constants.Url.ROLE_URL;

import org.mg.blog.base.controller.BaseController;
import org.mg.blog.role.service.RoleService;
import org.mg.blog.system.dto.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 角色 转发器
 *
 * @since 2020-09-25
 */
@Controller
@RequestMapping(value = ROLE_URL)
public class RoleController extends BaseController<RoleService, Role> {
    @Override
    @GetMapping
    public ModelAndView toList() {
        return createView("role/list");
    }

    @Override
    @GetMapping("/add")
    public ModelAndView toAdd() {
        return createView("role/add");
    }

    @Override
    @GetMapping("/{id}")
    public ModelAndView query(@PathVariable("id") String id) {
        Role role = service.query(id);
        return createView("role/detail").addObject("data", role);
    }
}
