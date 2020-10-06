package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.system.dto.Notice;

/**
 * 通知 mapper
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
}
