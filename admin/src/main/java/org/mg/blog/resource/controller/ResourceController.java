
package org.mg.blog.resource.controller;

import static org.mg.blog.constants.CommonConst.COLS_FIELD;
import static org.mg.blog.constants.CommonConst.URL_FIELD;
import static org.mg.blog.resource.constants.Url.RESOURCE_URL;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.base.BaseController;
import org.mg.blog.resource.service.ResourceService;
import org.mg.blog.system.dto.Resource;
import org.mg.blog.utils.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述
 *
 * @since 2020-09-26
 */
@Controller
@RequestMapping(value = RESOURCE_URL)
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;

    /**
     * to 资源列表页
     *
     * @return 资源列表页
     */
    @GetMapping
    public ModelAndView toList() {
        Map<String, Object> tableMap = new HashMap<>();
        tableMap.put(COLS_FIELD, FieldUtils.getFields(Resource.class));
        tableMap.put(URL_FIELD, RESOURCE_URL);
        tableMap.put("enablePage", "false");
        tableMap.put("enableExport", "false");
        return super.toList(tableMap);
    }

    /**
     * 查询列表数据
     *
     * @return 列表数据
     */
    @ResponseBody
    @PostMapping
    public Page<Resource> getList() {
        List<Resource> resources = resourceService.queryRoleResource(null);

        Page<Resource> page = new Page<>();
        page.setRecords(resources);
        return page;
    }
}
