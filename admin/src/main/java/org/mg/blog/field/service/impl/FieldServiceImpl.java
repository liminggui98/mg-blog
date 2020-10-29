
package org.mg.blog.field.service.impl;

import org.mg.blog.base.service.impl.BaseServiceImpl;
import org.mg.blog.field.service.FieldService;
import org.mg.blog.system.api.FieldApi;
import org.mg.blog.system.dto.Field;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 功能描述
 *
 * @since 2020-10-06
 */
@Service
public class FieldServiceImpl extends BaseServiceImpl<FieldApi, Field> implements FieldService {
    @Override
    public List<Field> queryByResourceId(String resourceId) {
        return Optional.of(api.queryByResourceId(resourceId).getResult())
                .orElse(Collections.emptyList());
    }
}
