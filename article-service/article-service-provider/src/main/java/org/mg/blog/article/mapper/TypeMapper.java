package org.mg.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.article.dto.Type;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
}
