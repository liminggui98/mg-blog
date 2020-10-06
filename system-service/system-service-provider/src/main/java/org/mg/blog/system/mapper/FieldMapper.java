
package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mg.blog.system.dto.Field;

import java.util.List;

/**
 * 资源字段
 *
 * @since 2020-10-06
 */
@Mapper
public interface FieldMapper extends BaseMapper<Field> {
    /**
     * 通过 resourceId 查询字段集
     *
     * @param resourceId 资源 id
     * @return 字段集
     */
    List<Field> queryByResourceId(@Param("resourceId") String resourceId);
}
