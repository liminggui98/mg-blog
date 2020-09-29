
package org.mg.blog.resource.service.impl;

import org.mg.blog.base.service.impl.BaseServiceImpl;
import org.mg.blog.resource.service.ResourceService;
import org.mg.blog.system.api.ResourcesApi;
import org.mg.blog.system.dto.Resource;
import org.springframework.stereotype.Service;

/**
 * 资源服务
 *
 * @since 2020-09-26
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<ResourcesApi, Resource> implements ResourceService {
}
