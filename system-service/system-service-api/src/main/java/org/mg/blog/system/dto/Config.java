
package org.mg.blog.system.dto;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.mg.blog.dto.DataBaseModel;

/**
 * 系统配置
 */
@Data
@TableName("tbl_config")
@EqualsAndHashCode(callSuper = false)
public class Config extends DataBaseModel {
    private String configKey;

    private String configValue;
}
