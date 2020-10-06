
package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.system.dto.Field;

/**
 * 资源字段
 *
 * @since 2020-10-06
 */
@Mapper
public interface FieldMapper extends BaseMapper<Field> {
}
