
package org.mg.blog.role.service.impl;

import org.mg.blog.base.service.impl.BaseServiceImpl;
import org.mg.blog.role.service.RoleService;
import org.mg.blog.system.api.RoleApi;
import org.mg.blog.system.dto.Role;
import org.springframework.stereotype.Service;

/**
 * 角色服务
 *
 * @since 2020-09-25
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleApi, Role> implements RoleService {
}
