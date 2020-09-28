
package org.mg.blog.resource.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.mg.blog.dto.Result;
import org.mg.blog.resource.service.ResourceService;
import org.mg.blog.system.api.ResourcesApi;
import org.mg.blog.system.dto.Resource;
import org.mg.blog.system.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 资源服务
 *
 * @since 2020-09-26
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourcesApi resourcesApi;

    @Override
    public Page<List<Resource>> queryResource(Page page) {
        Result<Page<List<Resource>>> result = resourcesApi.query(page);
        return Optional.ofNullable(result.getResult()).orElse(new Page<>());
    }

    @Override
    public List<Resource> queryRoleResource(Role role) {
        Result<List<Resource>> result = resourcesApi.queryUserResource("1");
        return Optional.ofNullable(result.getResult()).orElse(Collections.EMPTY_LIST);
    }
}
