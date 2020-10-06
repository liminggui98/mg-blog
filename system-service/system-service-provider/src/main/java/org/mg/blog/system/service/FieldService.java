
package org.mg.blog.system.service;

import org.mg.blog.service.BaseService;
import org.mg.blog.system.dto.Field;

import java.util.List;

/**
 * 功能描述
 *
 * @since 2020-10-06
 */
public interface FieldService extends BaseService<Field> {
    /**
     * 通过 resourceId 查询字段集
     *
     * @param resourceId 资源 id
     * @return 字段集
     */
    List<Field> queryByResourceId(String resourceId);
}
