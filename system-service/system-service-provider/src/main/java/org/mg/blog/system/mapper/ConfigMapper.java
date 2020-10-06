package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.system.dto.Config;

import java.util.List;

/**
 * 配置 mapper
 */
@Mapper
public interface ConfigMapper extends BaseMapper<Config> {
    List<Config> selectAll();
}
