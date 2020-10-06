package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.system.dto.Template;

/**
 * 模板 mapper
 */
@Mapper
public interface TemplateMapper extends BaseMapper<Template> {
}
