
package org.mg.blog.role.controller;

import static org.mg.blog.constants.CommonConst.COLS_FIELD;
import static org.mg.blog.constants.CommonConst.URL_FIELD;
import static org.mg.blog.role.constants.Url.ROLE_URL;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.base.BaseController;
import org.mg.blog.role.service.RoleService;
import org.mg.blog.system.dto.Role;
import org.mg.blog.utils.FieldUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * 角色 转发器
 *
 * @since 2020-09-25
 */
@Controller
@RequestMapping(value = ROLE_URL)
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    /**
     * 角色列表视图
     *
     * @return 角色列表视图
     */
    @GetMapping
    public ModelAndView toList() {
        Map<String, Object> tableMap = new HashMap<>();
        tableMap.put(COLS_FIELD, FieldUtils.getFields(Role.class));
        tableMap.put(URL_FIELD, ROLE_URL);
        return super.toList(tableMap);
    }

    /**
     * 查询列表数据
     *
     * @param page 分页条件
     * @return 列表数据
     */
    @ResponseBody
    @PostMapping
    public Page<List<Role>> getList(Page page) {
        return roleService.queryRoles(page);
    }
}
