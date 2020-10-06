
package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.system.dto.Link;

/**
 * link mapper
 * 
 * @since 2020-09-28
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {
}
