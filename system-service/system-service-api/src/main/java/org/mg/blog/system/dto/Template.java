package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mg.blog.dto.DataBaseModel;

/**
 * 模板
 */
@Data
@TableName("tbl_template")
@EqualsAndHashCode(callSuper = false)
public class Template extends DataBaseModel {
    private String refKey;
    private String refValue;
}
