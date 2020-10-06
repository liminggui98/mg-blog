package org.mg.blog.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mg.blog.system.dto.UpdateRecord;

/**
 * 更新记录 mapper
 */
@Mapper
public interface UpdateRecordMapper extends BaseMapper<UpdateRecord> {
}
