package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

import java.util.Date;

/**
 * 更新记录
 */
@Data
@TableName("tbl_update_record")
@EqualsAndHashCode(callSuper = false)
public class UpdateRecord extends DataBaseModel {
    private String version;
    private String description;
    private Date recordTime;
}
