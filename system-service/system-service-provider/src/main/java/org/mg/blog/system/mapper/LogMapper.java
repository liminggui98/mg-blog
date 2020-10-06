package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.system.dto.Log;

/**
 * Log 日志 mapper
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {
}
