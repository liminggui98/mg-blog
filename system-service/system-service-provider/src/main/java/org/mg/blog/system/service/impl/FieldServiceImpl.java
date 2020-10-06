
package org.mg.blog.system.service.impl;

import org.mg.blog.service.impl.BaseServiceImpl;
import org.mg.blog.system.dto.Field;
import org.mg.blog.system.mapper.FieldMapper;
import org.mg.blog.system.service.FieldService;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * 功能描述
 *
 * @since 2020-10-06
 */
@Service
public class FieldServiceImpl extends BaseServiceImpl<Field> implements FieldService {
    @Resource
    private FieldMapper fieldMapper;

    @Override
    public List<Field> queryByResourceId(String resourceId) {
        return fieldMapper.queryByResourceId(resourceId);
    }
}
