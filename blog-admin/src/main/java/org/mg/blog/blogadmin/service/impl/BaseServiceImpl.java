package org.mg.blog.blogadmin.service.impl;

import lombok.Data;
import org.mg.blog.blogadmin.service.BaseService;

/**
 * 基础服务
 */
@Data
public class BaseServiceImpl<T> implements BaseService<T> {
    private String tableName;

    @Override
    public T queryById(Integer id) {
        String querySql = getTableName();
        return null;
    }
}
